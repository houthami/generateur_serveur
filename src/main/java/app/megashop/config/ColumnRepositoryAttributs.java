package app.megashop.config;

import app.megashop.commun.Constant;

public class ColumnRepositoryAttributs extends ColumnAttributs{
    @Override
    public String toString() {
        String attribut = "";
        if(this.isPrimary()){
            attribut += Constant.PRIMARYID +"\n";
        }
        String columAnn = Constant.COLUMNANNOTATION.replaceFirst("__COLUMNID", super.getName()).replaceFirst("__NULLABLE", super.getNullable()).replaceFirst("__LENGTH", super.getSize());
        attribut += columAnn +"\n";
        attribut += super.getPrivilage()+" "+super.getType()+" "+super.getName()+";\n";
        return attribut;
    }

    public static ColumnRepositoryAttributs generateFromTableAttrs(String[] columnProps, String primaryKey){
        ColumnRepositoryAttributs columnAttributs = new ColumnRepositoryAttributs();
        columnAttributs.setProprieties(columnProps, primaryKey);
        return columnAttributs;
    }
}
