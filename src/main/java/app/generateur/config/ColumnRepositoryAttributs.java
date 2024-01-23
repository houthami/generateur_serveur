package app.generateur.config;

import app.generateur.commun.Constant;

public class ColumnRepositoryAttributs extends ColumnAttributs{
    @Override
    public String toString() {
        String attribut = "";
        if(this.isPrimary()){
            attribut += Constant.PRIMARYID +"\n";
        }
        String columAnn = Constant.COLUMNANNOTATION.replaceFirst("__COLUMNID", super.getName()).replaceFirst("__NULLABLE", String.valueOf(super.getNullable())).replaceFirst("__LENGTH", super.getSize());
        attribut += columAnn +"\n";
        attribut += super.getPrivilage()+" "+super.getType()+" "+super.getName()+";\n";
        return attribut;
    }
}
