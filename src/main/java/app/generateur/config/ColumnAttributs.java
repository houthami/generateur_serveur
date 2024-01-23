package app.generateur.config;

import app.generateur.commun.Constant;

import java.util.Set;

public class ColumnAttributs {
    private String name;
    private String privilage;
    private String type;
    private String size;
    private boolean nullable;
    private String tableNAme;
    private String reference;
    private boolean isPrimary;
    private boolean isForgien;
    private boolean isIndexed;
    private boolean isUnique;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public static ColumnAttributs generateFromTableAttrs(String[] columnProps, Set<String> primaryKey){
        ColumnAttributs columnAttributs = new ColumnAttributs();
        columnAttributs.setProprieties(columnProps, primaryKey);
        return columnAttributs;
    }

    public void setProprieties(String[] columnProps, Set<String> primaiesKeys){
        String type = columnProps[1].trim();
        String props = columnProps.length > 2 ? columnProps[2] : "null";
        if(primaiesKeys.size() == 1){
            this.setPrimary(primaiesKeys.contains(columnProps[0].trim()));
        }
        this.setName(columnProps[0].trim());
        this.setPrivilage(Constant.PRK);
        String[] typeDecop= type.split("[(]");
        this.setSize(typeDecop.length > 1 ? typeDecop[1].substring(0, typeDecop[1].length() - 1) : "1");
        this.setNullable(props != null?!props.toLowerCase().contains("not null"):true);
        this.setUnique(props.contains(Constant.ISINDEXEDKEY));
        if(props.contains(Constant.ISFORIENKEY)){
            this.setSize("");
            this.setForgien(true);
            int foriengBeginIndex = props.indexOf(Constant.ISFORIENKEY);
            int foriengEndIndex = props.indexOf(" ", foriengBeginIndex);
            type = props.substring(foriengBeginIndex + Constant.ISFORIENKEY.length(), foriengEndIndex == -1? props.length(): foriengEndIndex);
        }else{
            switch (typeDecop[0].toLowerCase()) {
                case "number":
                    type = Constant.INT;
                    break;
                case "varchar2":
                    this.setSize(typeDecop.length > 1 ? typeDecop[1].substring(0, typeDecop[1].length()) : "1");
                    type = Constant.STRING;
                    break;
                case "date":
                    type = Constant.DATE;
                    break;
                case "blob":
                    type = Constant.BLOB;
            }
        }
        this.setType(type);
    }


    public boolean isPrimary() {
        return isPrimary;
    }

    public boolean isUnique() {
        return isUnique;
    }

    public void setUnique(boolean unique) {
        isUnique = unique;
    }

    public boolean isNullable() {
        return nullable;
    }

    public boolean isForgien() {
        return isForgien;
    }

    public void setForgien(boolean forgien) {
        isForgien = forgien;
    }

    public boolean isIndexed() {
        return isIndexed;
    }

    public void setIndexed(boolean indexed) {
        isIndexed = indexed;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrivilage() {
        return privilage;
    }

    public void setPrivilage(String privilage) {
        this.privilage = privilage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean getNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getTableNAme() {
        return tableNAme;
    }

    public void setTableNAme(String tableNAme) {
        this.tableNAme = tableNAme;
    }
}
