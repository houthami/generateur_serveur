package app.megashop.config;

import app.megashop.commun.Constant;

public class ColumnAttributs {
    private String name;
    private String privilage;
    private String type;
    private String size;
    private String nullable;
    private String tableNAme;
    private boolean isPrimary;

    public static ColumnAttributs generateFromTableAttrs(String[] columnProps, String primaryKey){
        ColumnAttributs columnAttributs = new ColumnAttributs();
        columnAttributs.setProprieties(columnProps, primaryKey);
        return columnAttributs;
    }

    public void setProprieties(String[] columnProps, String primaryKey){
        String type = columnProps[1].trim();
        String props = columnProps.length > 2 ? columnProps[2] : null;
        if(primaryKey.equals(columnProps[0].trim())){
            this.setPrimary(true);
        }
        this.setName(columnProps[0].trim());
        this.setPrivilage(Constant.PRK);
        String[] typeDecop= type.split("[(]");
        this.setSize(typeDecop.length > 1 ? typeDecop[1].substring(0, typeDecop[1].length() - 1) : "1");
        this.setNullable(props != null?String.valueOf(!props.contains("not null")):"false");
        switch (typeDecop[0]) {
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
        this.setType(type);
    }


    public boolean isPrimary() {
        return isPrimary;
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

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getTableNAme() {
        return tableNAme;
    }

    public void setTableNAme(String tableNAme) {
        this.tableNAme = tableNAme;
    }
}
