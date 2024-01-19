package app.megashop.config;

import app.megashop.commun.Constant;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class DBInitializer {

    public DBInitializer()  {
        try{
            init();
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        System.out.println("MyBean constructor");
    }

    @PostConstruct
    public void myPostConstruct() {
        System.out.println(" @PostConstruct method");
    }

    public Object nvl(Object o1, Object o2){
        if((boolean) o1){
            return o1;
        }
        return o2;
    }
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:static/creation_tables.sql");
        InputStream in = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder[] tables = new StringBuilder[]{};
        try  {
            int i = 0;
            while(reader.ready()) {
                StringBuilder[] tempTables = new StringBuilder[tables.length + 1];
                System.arraycopy(tables, 0, tempTables, 0, tables.length);
                StringBuilder table = new StringBuilder();
                String line = reader.readLine();
                if(line.contains("CREATE__TABLE")){
                    line = reader.readLine();
                    table.append(line);
                    while(reader.ready()){
                        line = reader.readLine();
                        table.append(line);
                        if(line.contains("END__TABLE")){
                            parseTable(table);
                            break;
                        }
                    }
                    tempTables[i] = table;
                    tables = tempTables;
                    i++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void parseTable(StringBuilder table){
        TableAttributs tableAtt = TableAttributs.generateTableAtts(table);
        String className = NameClass(tableAtt.getName());
        String dir = System.getProperty("user.dir");
        dir = dir+Constant.PATHRELATIVE;
        System.out.println("current dir = " + dir);

        try{
            Map<String, Map<String, String>> content = generateClasseFormatFromTable(tableAtt, tableAtt.getPrimaryKey());
            Map<String, String> entity = content.getOrDefault(Constant.ENTITYKEY, new HashMap<>());
            String entityContent = tableAtt.toString(Constant.ENTITYKEY).replaceFirst("__IMPORTS", entity.getOrDefault(Constant.IMPORTS, "\n"))
                    .replaceFirst("__CLASSATTRIBUTS", entity.getOrDefault(Constant.ATTRIBUTS, "\n"))
                    .replaceFirst("__CLASSFUNCTION", "");
            FileWriter entityFile = new FileWriter(dir+"\\"+className+".java");
            entityFile.write(entityContent);
            entityFile.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Map<String, Map<String, String>> generateClasseFormatFromTable(TableAttributs tableAtts, String primaryKey){
        Map<String, Map<String, String>> content = new HashMap<>();
        String[] attributs = tableAtts.getAttributs();
        String[] functions = tableAtts.getFunctions();
        content = generateFromAttributes(content, attributs, primaryKey);
        return content;
    }

    private static Map<String, Map<String, String>> generateFromAttributes(Map<String, Map<String, String>> content, String[] attributs, String primaryKey) {
        ColumnAttributs columnAttributs = new ColumnAttributs();
        return IntStream.range(0, attributs.length)
                .mapToObj(i -> attributs[i]
                        .replaceAll(" +", " ")
                        .replaceAll("^\\s+", "")
                        .split(" ", 3))
                .collect(() -> content, (map, columnProps) ->
                                generateFromColumn(map, ColumnEntityAttributs.generateFromTableAttrs(columnProps, primaryKey)),
                        Map::putAll);
    }

    public static Map<String, Map<String, String>> generateFromColumn(Map<String, Map<String, String>> content, ColumnEntityAttributs column){
        String imports = "";
        Map<String, String> entityMap = content.getOrDefault(Constant.ENTITYKEY, new HashMap<>());
        switch (column.getType()) {
            case "Date":
                imports += "import java.util.Date;\n";
                break;
        }
        entityMap.put(Constant.ATTRIBUTS, entityMap.getOrDefault(Constant.ATTRIBUTS, "\n")+column.toString());
        entityMap.put(Constant.IMPORTS, entityMap.getOrDefault(Constant.IMPORTS, "\n")+imports);
        content.put(Constant.ENTITYKEY, entityMap);
        return content;
    }


    public String NameClass(String name){
        int index = name.indexOf("_");
        while (index != -1){
            name = name.substring(0, index)+name.substring(index+1, index+2).toUpperCase()+name.substring(index+2);
            index = name.indexOf("_");
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("@PreDestroy method");
    }
}
