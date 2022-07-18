package ch.dcreations.apviewer.Step3DModel;

import ch.dcreations.apviewer.Step3DModel.StepShapes.*;
import ch.dcreations.apviewer.Step3DModel.StepShapes.ConnectedFaceSet.ClosedShell;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.Curve;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Curve.SurfaceCurve;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.Edge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.EdgeCurve;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.Edge.OrientedEdge;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.AdvancedFace;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Face.Face;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.EdgeLoop;
import ch.dcreations.apviewer.Step3DModel.StepShapes.FaceBoundLoop.FaceBound;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.CartesianPoint;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Point.Point;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Plane;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Surfaces.Surface;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.SimpleVertexD;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.Vertex;
import ch.dcreations.apviewer.Step3DModel.StepShapes.Vertex.VertexPoint;

import java.util.*;

public class AP242Decoder {
    Map<Integer, String> dataMap;
    List<StepShapes> stepShapes = new ArrayList<>();
    List<ClosedShell> drawingShells = new ArrayList<>();

    public AP242Decoder(Map<Integer, String> dataMap) {
        this.dataMap = dataMap;
    }

    public void decode() {
        calculateDecoding(dataMap.get(3));
        System.out.println("END");
    }

    private String[] decodeKey(String value) {
        String[] code = new String[2];
        if (value.startsWith("(GEOMETRIC_REPRESENTATION_CONTEXT")) {
            code[0] = value;
            code[1] = "";
        } else {
            String topCode = value.substring(0, value.indexOf("("));
            String contend = value.substring(value.indexOf("(") + 1, value.length() - 1);
            code[0] = topCode;
            code[1] = contend;
        }
        return code;
    }

    private StepShapes calculateDecoding(String value) {
        String[] resived = decodeKey(value);
        String topCode = resived[0];
        String contend = resived[1];
        String[] numbers = contend.split(",");
        String name = numbers[0].replace("\"","");
        switch (topCode) {
            case "SHAPE_DEFINITION_REPRESENTATION" -> {
                String code1 = dataMap.get(Integer.valueOf(numbers[0].replace("#", "")));
                String code2 = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                ShapeDefinitionRepesentation s = new ShapeDefinitionRepesentation(calculateDecoding(code1), calculateDecoding(code2));
                stepShapes.add(s);
                return s;
            }
            case "ADVANCED_BREP_SHAPE_REPRESENTATION" -> {
                String code1 = dataMap.get(Integer.valueOf(numbers[numbers.length - 1].replace("#", "")));
                Set<StepShapes> items = new HashSet<>();
                for (int i = 1; i < numbers.length - 1; i++) {
                    String code = dataMap.get(Integer.valueOf(numbers[i].replace("#", "").replace("(", "").replace(")", "")));
                    items.add(calculateDecoding(code));
                }
                return new AdvancedBrepShapeRepresentation(name, items, calculateDecoding(code1));
            }
            case "PRODUCT_DEFINITION_SHAPE" -> {
                String description = numbers[1];
                String code1 = dataMap.get(Integer.valueOf(numbers[2].replace("#", "")));
                return new ProductDefinitionShape(name, description, calculateDecoding(code1));
            }
            case "PRODUCT_DEFINITION" -> {
                String description = numbers[1];
                String code1 = dataMap.get(Integer.valueOf(numbers[2].replace("#", "")));
                String code2 = dataMap.get(Integer.valueOf(numbers[3].replace("#", "")));
                return new ProductDefinition(name, description, calculateDecoding(code1), calculateDecoding(code2));
            }
            case "PRODUCT" -> {
                String id = numbers[0];
                name = numbers[1];
                String description = numbers[2];
                String code1 = dataMap.get(Integer.valueOf(numbers[3].replace("#", "").replace("(", "").replace(")", "")));
                Set<StepShapes> frameSet = new HashSet<>();
                calculateDecoding(code1);
                return new Product(id, name, description, frameSet);
            }
            case "PRODUCT_DEFINITION_FORMATION" -> {
                String description = numbers[1];
                String code1 = dataMap.get(Integer.valueOf(numbers[2].replace("#", "")));

                return new ProductDefinitionFormation(name, description, calculateDecoding(code1));
            }
            case "PRODUCT_DEFINITION_CONTEXT" -> {
                String disciplineType = numbers[2];
                String code1 = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                return new ProductDefinitionContext(name, calculateDecoding(code1), disciplineType);
            }
            case "PRODUCT_CONTEXT" -> {
                String disciplineType = numbers[2];
                String code1 = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                return new ProductContext(name, calculateDecoding(code1), disciplineType);
            }
            case "APPLICATION_CONTEXT" -> {
                return new ApplicationContext(name);
            }
            case "AXIS2_PLACEMENT_3D" -> {
                String location = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                String axis1 = dataMap.get(Integer.valueOf(numbers[2].replace("#", "")));
                String refDirection = dataMap.get(Integer.valueOf(numbers[3].replace("#", "")));
                try {
                    return new Axis2Placement3D(name, calculateDecoding(location), calculateDecoding(axis1), calculateDecoding(refDirection));
                } catch (Exception e) {
                    System.err.println("AXIS2_PLACEMENT_3D parrameter Error");
                    return null;
                }
            }
            case "CARTESIAN_POINT" -> {
                return new CartesianPoint(name, directionRaitiosToList(numbers));
            }
            case "MANIFOLD_SOLID_BREP" -> {
                String shapeData = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                return new MainfoldSolidBrep(name, calculateDecoding(shapeData));
            }
            case "DIRECTION" -> {
                List<Double> directionRatios = directionRaitiosToList(numbers);
                return new Direction(name, directionRatios);
            }
            case "CLOSED_SHELL" -> {
                try {
                    Set<Face> setOfFaces = getFacesSet(numbers);
                    ClosedShell closedShell = new ClosedShell(name, setOfFaces);
                    drawingShells.add(closedShell);
                    return closedShell;
                }catch (Exception e) {
                    System.err.println("CLOSED_SHELL ERROR");
                    System.err.println(e.getMessage());
                    return null;
                }
            }
            case "ADVANCED_FACE" -> {
                String code = dataMap.get(Integer.valueOf(numbers[numbers.length - 2].replace("#", "").replace("(", "").replace(")", "")));
                try {
                    Surface faceGeometrie = (Surface) calculateDecoding(code);
                    Boolean sameSense = !Objects.equals(numbers[numbers.length - 1], ".F.");
                    return new AdvancedFace(name, getItemsSet(numbers, FaceBound.class), faceGeometrie, sameSense);
                } catch (Exception e) {
                    System.err.println("ADVANCED FACE faceGemetrie was not a Surface");
                    System.err.println(e.getMessage());
                    return null;
                }
            }
            case "FACE_BOUND" -> {
                try {
                    String code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                    EdgeLoop faceLoop = (EdgeLoop)calculateDecoding(code);
                    Boolean orientation = !Objects.equals(numbers[numbers.length - 1], ".F.");
                    return new FaceBound(name, faceLoop, orientation);
                } catch (Exception e) {
                    System.err.println("FaceBound failed failed");
                    System.err.println(e.getMessage());
                    return null;
                }
            }
            case "EDGE_LOOP" -> {
                try {
                return new EdgeLoop(name,getFacesSet(numbers));
            } catch (Exception e) {
                System.err.println("EDGE_LOOP failed");
                System.err.println(e.getMessage());
                return null;
            }
            }
            case "ORIENTED_EDGE" -> {
                try {
                    String edgeStart = numbers[1];
                    String edgeEnd = numbers[2];
                    String code = dataMap.get(Integer.valueOf(numbers[3].replace("#", "")));
                    Edge edgeElement = (Edge) calculateDecoding(code);
                    Boolean orientation = !Objects.equals(numbers[numbers.length - 1], ".F.");
                    return new OrientedEdge(name, new SimpleVertexD(edgeStart), new SimpleVertexD(edgeEnd), edgeElement, orientation);
                } catch (Exception e) {
                    System.err.println("ORIENTATED EDGE Vertex or EdgeElement was Wrong" + "Exeption" + e.getMessage());
                    return null;
                }
            }
            case "EDGE_CURVE" -> {
                try {
                    String code1 = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                    String code2 = dataMap.get(Integer.valueOf(numbers[2].replace("#", "")));
                    String code3 = dataMap.get(Integer.valueOf(numbers[3].replace("#", "")));
                    Vertex edgeStart = (Vertex) calculateDecoding(code1);//vertex
                    Vertex edgeEnd = (Vertex) calculateDecoding(code2);//vertex
                    Curve edgeGeometrie = (Curve) calculateDecoding(code3);//vertex
                    Boolean sameSense = numbers[numbers.length - 1] != ".F.";
                    if (edgeStart.getTyp() == AP242Code.VERTEX_POINT && edgeEnd.getTyp() == AP242Code.VERTEX_POINT) {
                        return new EdgeCurve(name, (VertexPoint) calculateDecoding(code1), (VertexPoint) calculateDecoding(code2), edgeGeometrie, sameSense);
                    }
                    return new EdgeCurve(name, edgeStart, edgeEnd, edgeGeometrie, sameSense);
                } catch (Exception e) {
                    System.err.println("PLANE position was not a Position");
                    return null;
                }
            }
            case "VERTEX_POINT" -> {
                try {
                    String code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                    StepShapes point = calculateDecoding(code);//vertex
                    if (point.getTyp() == AP242Code.CARTESIAN_POINT)
                        return new VertexPoint(name, (CartesianPoint) calculateDecoding(code));
                    if (point.getTyp() == AP242Code.POINT)
                        return new VertexPoint(name, (Point) calculateDecoding(code));
                    throw new IllegalArgumentException("Wrong Point ");
                } catch (Exception e) {
                    System.err.println("PLANE position was not a Position");
                    return null;
                }
            }
            case "VECTOR" -> {
                String code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                StepShapes orientation = calculateDecoding(code);//vertex
                Double length = Double.valueOf(dataMap.get(Integer.valueOf(numbers[1].replace("#", ""))));
                return new StepVector(name, orientation, length);
            }

            case "LINE" -> {
                String code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                StepShapes coordinateSystem = calculateDecoding(code);//vertex
                code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                StepShapes vector = calculateDecoding(code);//vertex
                return new StepLine(name, coordinateSystem, vector);
            }
            case "PLANE" -> {
                String code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                try {
                    Axis2Placement3D position = (Axis2Placement3D) calculateDecoding(code);//vertex
                    return new Plane(name, position);
                } catch (Exception e) {
                    System.err.println("PLANE position was not a Position");
                    return null;
                }
            }
            case "PCURVE" -> {
                String code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                StepShapes basis = calculateDecoding(code);//vertex
                code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                StepShapes curve = calculateDecoding(code);//vertex
                return new Pcurve(name, basis, curve);
            }
            case "DEFINITIONAL_REPRESENTATION" -> {
                Set<StepShapes> items = getItemsSet(numbers, StepShapes.class);
                String code = dataMap.get(Integer.valueOf(numbers[numbers.length - 1].replace("#", "")));
                StepShapes representationContex = calculateDecoding(code);//vertex
                return new DefinitionalRepresentation(name, items, representationContex);
            }
            case "SURFACE_CURVE" -> {
                String code = dataMap.get(Integer.valueOf(numbers[1].replace("#", "")));
                StepShapes curve = calculateDecoding(code);//vertex
                Set<StepShapes> items = new HashSet<>();
                for (int i = 2; i < numbers.length - 1; i++) {
                    code = dataMap.get(Integer.valueOf(numbers[i].replace("#", "").replace("(", "").replace(")", "")));
                    items.add(calculateDecoding(code));
                }
                PreferredSurfaceCurveRepresentation representation = getPreferredEnum(numbers[numbers.length - 1].replace("#", ""));
                return new SurfaceCurve(name, curve, items, representation);
            }

            default -> {
                return null;
            }
        }

    }

    private PreferredSurfaceCurveRepresentation getPreferredEnum(String s) {
        switch (s) {
            case ".PCURVE_3D." -> {
                return PreferredSurfaceCurveRepresentation.CURVE3D;
            }
            case ".PCURVE_S2." -> {
                return PreferredSurfaceCurveRepresentation.pCURVE_s2;
            }
            default -> {
                return PreferredSurfaceCurveRepresentation.PCURVE_s1;
            }
        }
    }

    private <T, U> Set<T> getItemsSet(String[] numbers, U obj) {
        Set<T> items = new HashSet<>();
        for (int i = 1; i < numbers.length - 2; i++) {
            String code = dataMap.get(Integer.valueOf(numbers[i].replace("#", "").replace("(", "").replace(")", "")));
            if (obj.equals(calculateDecoding(code).getClass())) {
                items.add((T) calculateDecoding(code));
            } else {
                throw new IllegalArgumentException("At get Items object Type " + calculateDecoding(code).getClass() + " does not have same Type like T" + obj.getClass());
            }
        }
        return items;
    }

    private <T> Set<T> getFacesSet(String[] numbers) {
        Set<T> setOfFaces = new HashSet<>();
        for (int i = 1; i < numbers.length; i++) {
            String code = dataMap.get(Integer.valueOf(numbers[i].replace("#", "").replace("(", "").replace(")", "")));
            setOfFaces.add((T)calculateDecoding(code));
        }
        return setOfFaces;
    }

    private List<Double> directionRaitiosToList(String[] numbers) {
        List<Double> directionRatios = new ArrayList<>();
        for (int i = 1; i < numbers.length; i++) {
            Double code = Double.valueOf(numbers[i].replace("#", "").replace("(", "").replace(")", ""));
            directionRatios.add(code);
        }
        return directionRatios;
    }


    public List<ClosedShell> getDrawingShells() {
        return drawingShells;
    }

    public List<StepShapes> getStepShapes() {
        return stepShapes;
    }
}
