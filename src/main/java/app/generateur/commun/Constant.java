package app.generateur.commun;
public class Constant {
    public static final String BEGINTABLE = "create table";
    public static final String TABLEINVCAMBER = ");";

    public static final String INVCAMBER = ")";
    public static final String CAMBER = "(";
    public static final String PRIMARYKEY = "primary key";
    public static final String FOREIGNKEY = "foreign key";
    public static final String INDEXKEY = "CREATE UNIQUE INDEX";
    public static final String REFERENCES = "references";
    public static  final String PATHRELATIVE = "\\src\\main\\java\\app\\generateur\\";
    public static final String ENTITYTEMPLATE = "package app.generateur.entity;\n"+
                                                      "\n"+
                                                      "import jakarta.persistence.Id;\n" +
                                                      "import org.springframework.stereotype.Component;\n" +
                                                      "import javax.persistence.Column;\n" +
                                                      "import javax.persistence.*;\n" +
                                                      "\n" +
                                                      "__IMPORTS\n" +
                                                      "import jakarta.persistence.Entity;\n" +
                                                      "import javax.persistence.GeneratedValue;\n"+
                                                      "import javax.persistence.GenerationType;\n"+
                                                      "import javax.persistence.Table;\n"+
                                                      "\n"+
                                                      "@Entity\n"+
                                                      "@Component\n"+
                                                      "@Table(name=\"__TABLENAME\")\n" +
                                                      "public class __CLASSNAME extends BasicEntity {\n"+
                                                      "__PRIMARYKEY\n"+
                                                      "__CLASSATTRIBUTS\n"+
                                                      "\n"+
                                                      "__CLASSFUNCTION\n"+
                                                      "}\n"+
            "__IDCOMLEX";

    public static final String REPOSITORYTEMPLATE = "package app.generateur.repository;\n"+
                                                    "\n"+
                                                    "import org.springframework.data.repository.CrudRepository;\n" +
                                                    "\n" +
                                                    "__IMPORTS\n" +
                                                    "public interface __CLASSNAMERepository extends CrudRepository<__CLASSNAME, Long> {\n"+
                                                    "__CLASSFUNCTION\n"+
                                                    "}";

    public static final String IDCOMPLEX =  "package app.generateur.entity.entityId;\n" +
                                            "import java.io.Serializable;\n" +
                                            "\n" +
                                            "public class DmsMetadataDocId implements Serializable {\n" +
                                            "\n" +
                                            "__CLASSATTRIBUTS\n"+
                                            "\n" +
                                            "    // Constructors, getters, setters, equals, and hashCode methods\n" +
                                            "}";
    public static final String PRIMARYID = "@Id";
    public static final String GENERATEDVALUE = "@GeneratedValue(strategy = GenerationType.AUTO)";
    public static final String COLUMN = "@Column";
    public static final String ENTITY = "@Entity";
    public static final String ONETOMANY = "@OneToMany(mappedBy=\"__MAPPEDBY\")";
    public static final String MANYTOONE = "@ManyToOne(fetch = FetchType.LAZY, optional = false)";
    public static final String ONETOONE = "@OneToOne(cascade = CascadeType.ALL)";
    public static final String JOINCOLUMNANNOATATION = "@JoinColumn(name=\"__COLUMNID\"__NULLABLE__REFERENCE__UNIQUE)";
    public static final String COLUMNANNOTATION = "@Column(name=\"__COLUMNID\"__NULLABLE__LENGTH__UNIQUE)";

    public static final String UNIQUEANNOTATION = ", unique=";
    public static final String LENGTHANNOTATION = ", length=";
    public static final String NULLABLEANNOTATION = ", nullable=";
    public static final String REFERENCEANNOTATION = ", referencedColumnName = ";
    public static final String TABLEANNOTATION = "@Table(name=\"__TABLENAME\")";
    public static final String PRK = "private";
    public static final String PTK = "protected";
    public static final String PVK = "public";
    public static final String INT = "int";
    public static final String FLOAT = "float";
    public static final String DOUBLE = "double";
    public static final String STRING = "String";
    public static final String DATE = "Date";
    public static final String LIST = "List";
    public static final String SET = "Set";
    public static final String MAP = "Map";
    public static final String ATTRIBUTS = "attributs";
    public static final String FUNCTIONS = "function";
    public static final String IMPORTS = "imports";
    public static final String BLOB = "byte[]";
    public static final String ENTITYKEY = "entity";
    public static final String REPOSITORYKEY = "repository";
    public static final String SERVICEKEy = "service";
    public static final String DTOKEY = "dto";
    public static final String ISFORIENKEY = "isforienkey";
    public static final String ISINDEXEDKEY = "isindexedkey";
}
