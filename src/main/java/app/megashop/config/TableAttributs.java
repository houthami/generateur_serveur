package app.megashop.config;

import app.megashop.commun.Constant;

import java.util.ArrayList;
import java.util.List;

public class TableAttributs {
    private String name;
    private String primaryKey;
    private ForeignKey[] forientKeys;
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
        int tableIndex = table.indexOf(Constant.BEGINTABLE);
        int tableATTR = table.indexOf(Constant.CAMBER, tableIndex);
        int tableEnd = table.indexOf(Constant.TABLEINVCAMBER, tableATTR);
        int primaryKeyIndex = table.indexOf(Constant.PRIMARYKEY);
        int primaryKeyBegin = table.indexOf(Constant.CAMBER, primaryKeyIndex) + 1;
        int primaryKeyInvEnd = table.indexOf(Constant.INVCAMBER, primaryKeyBegin);
        this.setName(table.substring(tableIndex + Constant.BEGINTABLE.length(), tableATTR).trim());
        this.setAttributs(table.substring(tableATTR + 1, tableEnd));
        this.setPrimaryKey(table.substring(primaryKeyBegin, primaryKeyInvEnd));
        int foreignKeyIndex = table.indexOf(Constant.FOREIGNKEY);
        ForeignKey[] foreignKeys = new ForeignKey[]{};
        int i = 0;
        while(foreignKeyIndex != -1){
            ForeignKey[] foreignKeysTemp = new ForeignKey[i + 1];
            System.arraycopy(foreignKeys, 0, foreignKeysTemp, 0, foreignKeys.length);
            int foreignKeyBegin = table.indexOf(Constant.CAMBER, foreignKeyIndex) + 1;
            int foreignKeyInvEnd = table.indexOf(Constant.INVCAMBER, foreignKeyBegin);
            String foreignKey = table.substring(foreignKeyBegin, foreignKeyInvEnd);
            int refKeyIndex = table.indexOf(Constant.REFERENCES, foreignKeyInvEnd);
            int refKeyEnd = table.indexOf(Constant.CAMBER, refKeyIndex);
            String refKey = table.substring(refKeyIndex+Constant.REFERENCES.length(), refKeyEnd);
            foreignKeysTemp[i] = new ForeignKey(foreignKey, this.nameClass(refKey.trim()));
            foreignKeyIndex = table.indexOf(Constant.FOREIGNKEY, refKeyEnd);
            foreignKeys =  foreignKeysTemp;
            i++;
        }

        this.setForientKeys(foreignKeys);
    }

    public String nameClass(){
        int index = this.name.indexOf("_");
        while (index != -1){
            this.name = this.name.substring(0, index)+this.name.substring(index+1, index+2).toUpperCase()+this.name.substring(index+2);
            index = this.name.indexOf("_");
        }
        return this.name.substring(0, 1).toUpperCase() + this.name.substring(1);
    }

    public String nameClass(String name){
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

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

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
        }
        if (this.getForientKeys() != null && this.getForientKeys().length != 0) {
            for(ForeignKey f :this.getForientKeys()){
                result += "/*"+f.toString() + "*/\n";
            }
        }
        return result;
    }

}
