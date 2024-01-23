package app.generateur.config;

import app.generateur.commun.Constant;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class TableAttributs {
    private String name;
    //private String primaryKey;
    private Set<String> primariesKey;

    public Set<String> getPrimariesKey() {
        return primariesKey;
    }

    public void setPrimariesKey(Set<String> primariesKey) {
        this.primariesKey = primariesKey;
    }

    private ForeignKey[] forientKeys;
    private IndexKey[] indexKeys;
    private String[] attributs;
    private String[] functions;

    public void setAttributs(String[] attributs) {
        this.attributs = attributs;
    }

    public static TableAttributs generateTableAtts(StringBuilder table){
        TableAttributs tableAttributs = new TableAttributs();
        tableAttributs.setProprieties(table);
        return tableAttributs;
    }
    public void setProprieties(StringBuilder table){
        
        int tableIndex = StringUtils.indexOfIgnoreCase(table, Constant.BEGINTABLE);
        int tableATTR = StringUtils.indexOfIgnoreCase(table, Constant.CAMBER, tableIndex);
        int tableEnd = StringUtils.indexOfIgnoreCase(table, Constant.TABLEINVCAMBER, tableATTR);
        int primaryKeyIndex = StringUtils.indexOfIgnoreCase(table, Constant.PRIMARYKEY);
        int primaryKeyBegin = StringUtils.indexOfIgnoreCase(table, Constant.CAMBER, primaryKeyIndex) + 1;
        int primaryKeyInvEnd = StringUtils.indexOfIgnoreCase(table, Constant.INVCAMBER, primaryKeyBegin);
        this.setName(table.substring(tableIndex + Constant.BEGINTABLE.length(), tableATTR).trim());
        this.setAttributs(table.substring(tableATTR + 1, tableEnd));
        this.primariesKey = new HashSet<>();
        for (String primary: table.substring(primaryKeyBegin, primaryKeyInvEnd).split(",")) {
            this.primariesKey.add(primary.trim());
        }
        int foreignKeyIndex = StringUtils.indexOfIgnoreCase(table, Constant.FOREIGNKEY);
        int indexKeyIndex = StringUtils.indexOfIgnoreCase(table, Constant.INDEXKEY);
        ForeignKey[] foreignKeys = new ForeignKey[]{};
        IndexKey[] indexKeys = new IndexKey[]{};
        int i = 0, j = 0;
        while(foreignKeyIndex != -1){
            ForeignKey[] foreignKeysTemp = new ForeignKey[i + 1];
            System.arraycopy(foreignKeys, 0, foreignKeysTemp, 0, foreignKeys.length);
            int foreignKeyBegin = StringUtils.indexOfIgnoreCase(table, Constant.CAMBER, foreignKeyIndex) + 1;
            int foreignKeyInvEnd = StringUtils.indexOfIgnoreCase(table, Constant.INVCAMBER, foreignKeyBegin);
            String foreignKey = table.substring(foreignKeyBegin, foreignKeyInvEnd);
            int refKeyIndex = StringUtils.indexOfIgnoreCase(table, Constant.REFERENCES, foreignKeyInvEnd);
            int refKeyEnd = StringUtils.indexOfIgnoreCase(table, Constant.CAMBER, refKeyIndex);
            String refKey = table.substring(refKeyIndex+Constant.REFERENCES.length(), refKeyEnd);
            int refColIndex = StringUtils.indexOfIgnoreCase(table, Constant.CAMBER, refKeyEnd);
            int refColEnd = StringUtils.indexOfIgnoreCase(table, Constant.INVCAMBER, refColIndex);
            foreignKeysTemp[i] = new ForeignKey(foreignKey, this.nameClass(refKey.trim()));
            foreignKeyIndex = StringUtils.indexOfIgnoreCase(table, Constant.FOREIGNKEY, refKeyEnd);
            foreignKeys =  foreignKeysTemp;
            i++;
        }

        while(indexKeyIndex != -1){
            IndexKey[] indexKeysTemps = new IndexKey[j+1];
            System.arraycopy(indexKeys, 0, indexKeysTemps, 0, indexKeys.length);
            int indexKeyBegin = StringUtils.indexOfIgnoreCase(table, Constant.CAMBER, indexKeyIndex) + 1;
            int indexKeyInvEnd = StringUtils.indexOfIgnoreCase(table, Constant.INVCAMBER, indexKeyBegin);
            String indexKey = table.substring(indexKeyBegin, indexKeyInvEnd).trim().toLowerCase();
            indexKeysTemps[j] = new IndexKey(indexKey, true);
            indexKeyIndex = StringUtils.indexOfIgnoreCase(table, Constant.INDEXKEY, indexKeyInvEnd);
            indexKeys = indexKeysTemps;
            j++;
        }
        this.setIndexKeys(indexKeys);
        this.setForientKeys(foreignKeys);
    }

    public IndexKey[] getIndexKeys() {
        return indexKeys;
    }

    public void setIndexKeys(IndexKey[] indexKeys) {
        this.indexKeys = indexKeys;
    }

    public String nameClass(){
        name = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
        int index = this.name.indexOf("_");
        while (index != -1){
            this.name = this.name.substring(0, index)+this.name.substring(index+1, index+2).toUpperCase()+this.name.substring(index+2);
            index = this.name.indexOf("_");
        }
        return this.name.substring(0, 1).toUpperCase() + this.name.substring(1);
    }

    public String nameClass(String name){
        name = name.substring(0, 1).toUpperCase()+name.substring(1).toLowerCase();
        int index = name.indexOf("_");
        while (index != -1){
            name = name.substring(0, index)+name.substring(index+1, index+2).toUpperCase()+name.substring(index+2);
            index = name.indexOf("_");
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }*/

    public ForeignKey[] getForientKeys() {
        return forientKeys;
    }

    public void setForientKeys(ForeignKey[] forientKeys) {
        this.forientKeys = forientKeys;
    }

    public String[] getAttributs() {
        return attributs;
    }

    public void setAttributs(String attributs) {
        this.attributs = attributs.split(",");
    }

    public String[] getFunctions() {
        return functions;
    }

    public void setFunctions(String[] functions) {
        this.functions = functions;
    }

    public String toString(String type) {
        String result  ="";
        String nameTable = this.getName();
        switch (type){
            case Constant.ENTITYKEY:
                result= Constant.ENTITYTEMPLATE.replaceFirst("__CLASSNAME", this.nameClass())
                        .replaceFirst("__TABLENAME", nameTable);
            break;
            case Constant.REPOSITORYKEY:
                result= Constant.REPOSITORYTEMPLATE.replaceAll("__CLASSNAME", this.getName())
                        .replaceFirst("__TABLENAME", nameTable);
                break;
        }
        if (this.getForientKeys() != null && this.getForientKeys().length != 0) {
            for(ForeignKey f :this.getForientKeys()){
                result += "/*"+f.toString() + "*/\n";
            }
        }
        return result;
    }

}
