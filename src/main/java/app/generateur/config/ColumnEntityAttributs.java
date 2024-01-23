package app.generateur.config;

import app.generateur.commun.Constant;

import java.util.Set;

public class ColumnEntityAttributs extends ColumnAttributs{
    @Override
    public String toString() {
        String attribut = "";
        String columAnn = Constant.COLUMNANNOTATION;
        if(this.isPrimary()){
            attribut += Constant.PRIMARYID +"\n";
            attribut += Constant.GENERATEDVALUE+"\n";
        }
        if(this.isForgien() && this.isUnique()){
            attribut += Constant.ONETOONE+"\n";
            columAnn = Constant.JOINCOLUMNANNOATATION;
        } else if(this.isForgien()){
            attribut += Constant.MANYTOONE+"\n";
            columAnn = Constant.JOINCOLUMNANNOATATION;
        }
        columAnn = columAnn.replaceFirst("__COLUMNID", super.getName())
                .replaceFirst("__NULLABLE", super.getNullable()?"":Constant.NULLABLEANNOTATION+super.getNullable())
                .replaceFirst("__LENGTH", super.getSize().length() != 0 ? Constant.LENGTHANNOTATION+super.getSize(): "")
                .replaceFirst("__REFERENCE", this.getReference() == null? "": Constant.REFERENCEANNOTATION+this.getReference())
                .replaceFirst("__UNIQUE", this.isUnique()? Constant.UNIQUEANNOTATION+"true": "");
        attribut += columAnn +"\n";
        attribut += super.getPrivilage()+" "+super.getType()+" "+super.getName()+";\n";
        return attribut;
    }

    public static ColumnEntityAttributs generateFromTableAttrs(String[] columnProps, Set<String> primaryKey){
        ColumnEntityAttributs columnAttributs = new ColumnEntityAttributs();
        columnAttributs.setProprieties(columnProps, primaryKey);
        return columnAttributs;
    }
}
