package ch.dcreations.apviewer.Step3DModel;

import ch.dcreations.apviewer.Step3DModel.StepShapes.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AP242Decoder {
    Map<Integer,String> dataMap;
    Map<AP242Code, StepShapes> decodedMap;
    List<StepShapes> ModeliShapes = new ArrayList<>();
    public AP242Decoder(Map<Integer, String> dataMap) {
        this.dataMap = dataMap;
    }

    public void decode() {
       /* for (int i = dataMap.keySet().size();i >0;i--){
            String value = dataMap.get(i);
            while (value.contains("#")){
                int start = value.indexOf("#");
                int comma = value.indexOf(",",start);
                int bracket = value.indexOf(")",start);
                int point =  value.indexOf("\'",start);
                int end = (comma!=-1)&(bracket!=-1)&(comma < bracket)||(bracket==-1) ? comma : bracket;
                end = (point!=-1)&(end !=-1)&(end < point)||(point==-1) ? end : point;
                String number = value.substring(start,end);
                int numberValue = Integer.valueOf(value.substring(start+1,end));
                value = value.replace(number,dataMap.get(numberValue));
            }
            dataMap.put(i,value);

        for (Integer key : dataMap.keySet()){
        }
        }*/

        StepShapes part = calculateDecoding(dataMap.get(3));
        System.out.println("END");
    }

    private String[] decodeKey(String value){
        String[] code = new String[2];
        if (value.startsWith("(GEOMETRIC_REPRESENTATION_CONTEXT")){
            code[0] = value;
            code[1] = "";
        }else {
            String topCode = value.substring(0,value.indexOf("("));
            String contend = value.substring(value.indexOf("(")+1,value.length()-1);
            code[0] = topCode;
            code[1] = contend;
        }
        return code;
    }

    private StepShapes calculateDecoding(String value) {
        String[] resived = decodeKey(value);
        String topCode = resived[0];
        String contend = resived[1];
        String[] ret = contend.split(",");
        String[] numbers = contend.split(",");
        switch (topCode){
            case "SHAPE_DEFINITION_REPRESENTATION" -> {
                String code1 = dataMap.get(Integer.valueOf(numbers[0].replace("#","")));
                String code2 = dataMap.get(Integer.valueOf(numbers[1].replace("#","")));
                return new ShapeDefinitionRepesentation(calculateDecoding(code1),calculateDecoding(code2));}
            case "ADVANCED_BREP_SHAPE_REPRESENTATION" ->{
                String name = numbers[0];
                String code1 = dataMap.get(Integer.valueOf(numbers[numbers.length-1].replace("#","")));
                Set<StepShapes> items = new HashSet<>();
                for (int i = 1;i < numbers.length-1;i++){
                    String code = dataMap.get(Integer.valueOf(numbers[i].replace("#","").replace("(","").replace(")","")));
                    items.add(calculateDecoding(code));
                }
                return new AdvancedBrepShapeRepresentation(name,items,calculateDecoding(code1));
            }
            case "PRODUCT_DEFINITION_SHAPE" -> {
                String name = numbers[0];
                String description = numbers[1];
                String code1 = dataMap.get(Integer.valueOf(numbers[2].replace("#","")));
                return new ProductDefinitionShape(name,description,calculateDecoding(code1));
            }
            case "PRODUCT_DEFINITION" ->{
                String name = numbers[0];
                String description = numbers[1];
                String code1 = dataMap.get(Integer.valueOf(numbers[2].replace("#","")));
                String code2 = dataMap.get(Integer.valueOf(numbers[3].replace("#","")));
                return new ProductDefinition(name,description,calculateDecoding(code1),calculateDecoding(code2));
            }
            case "PRODUCT" -> {
                String id = numbers[0];
                String name = numbers[1];
                String description = numbers[2];
                String code1 = dataMap.get(Integer.valueOf(numbers[3].replace("#","").replace("(","").replace(")","")));
                Set<StepShapes> frameSet = new HashSet<>();
                calculateDecoding(code1);
                return new Product(id,name,description,frameSet);
            }
            case "PRODUCT_DEFINITION_FORMATION" -> {
                    String name = numbers[0];
                    String description = numbers[1];
                    String code1 = dataMap.get(Integer.valueOf(numbers[2].replace("#","")));

                    return new ProductDefinitionFormation(name,description,calculateDecoding(code1));
            }
            case "PRODUCT_DEFINITION_CONTEXT" -> {
                String name = numbers[0];
                String disciplineType = numbers[2];
                String code1 = dataMap.get(Integer.valueOf(numbers[1].replace("#","")));
                return new ProductDefinitionContext(name,calculateDecoding(code1),disciplineType);
            }
            case "PRODUCT_CONTEXT" -> {
                String name = numbers[0];
                String disciplineType = numbers[2];
                String code1 = dataMap.get(Integer.valueOf(numbers[1].replace("#","")));
                return new ProductContext(name,calculateDecoding(code1),disciplineType);
            }
            case "APPLICATION_CONTEXT" -> {
                String name = numbers[0];
                return new ApplicationContext(name);
            }
            case "AXIS2_PLACEMENT_3D" -> {
                String name = numbers[0];
                String location = dataMap.get(Integer.valueOf(numbers[1].replace("#","")));
                String axis1 = dataMap.get(Integer.valueOf(numbers[2].replace("#","")));
                String refDirection = dataMap.get(Integer.valueOf(numbers[3].replace("#","")));

                return new axis2Placement3D(name,calculateDecoding(location),calculateDecoding(axis1),calculateDecoding(refDirection));
            }
            case "CARTESIAN_POINT" -> {
                String name = numbers[0];
                List<Double> directionRatios = new ArrayList<>();
                for (int i = 1;i < numbers.length;i++){
                    Double code = Double.valueOf(numbers[i].replace("#","").replace("(","").replace(")",""));
                    directionRatios.add(code);
                }
                return new cartesianPoint(name,directionRatios);
            }
            case "MANIFOLD_SOLID_BREP" -> {
                String name = numbers[0];
                String shapeData = dataMap.get(Integer.valueOf(numbers[1].replace("#","")));
                return new MainfoldSolidBrep(name,calculateDecoding(shapeData));
            }
            case "DIRECTION" -> {
                String name = numbers[0];
                List<Double> directionRatios = new ArrayList<>();
                for (int i = 1;i < numbers.length;i++){
                    Double code = Double.valueOf(numbers[i].replace("#","").replace("(","").replace(")",""));
                    directionRatios.add(code);
                }
                return new Direction(name,directionRatios);
            }
            case "CLOSED_SHELL" -> {
                String name = numbers[0];
                Set<StepShapes> setOfFaces = new HashSet<>();
                for (int i = 1;i < numbers.length;i++){
                    String code = dataMap.get(Integer.valueOf(numbers[i].replace("#","").replace("(","").replace(")","")));
                    setOfFaces.add(calculateDecoding(code));
                }
                    return new ClosedShell(name,setOfFaces);
            }

            default -> {return null;}
        }

    }

    private void shapeRepresentation(String code){
        String dfs = "This order was placed for QT3000! OK?";
        String pattern = "(.*),(([',\\-,\\._A-Z]*\\([',\\-,\\._A-Z]*\\))*),(.*)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(code);
        m.matches();
        System.out.println(code);
                        // - Subtype: CartesianPoint PointOnSurface PointOnCurve DegeneratePcurve

    }

}
