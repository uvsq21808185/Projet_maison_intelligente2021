package itsudparis.application;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;

import itsudparis.tools.FileTool;
import itsudparis.tools.JenaEngine;

public class StreamInputDataset {
	
    public static final String ns = "http://www.semanticweb.org/win10/ontologies/2021/0/untitled-ontology-15#";
    public static final String rdfs = "http://www.w3.org/2000/01/rdf-schema#";
    public static final String rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
	  public void run(Model model) {

	        // dataset path
	        String fileName = "data/data.txt";
	        //read file into stream, try-with-resources
	        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
	        	
	            stream.forEach(line -> {
	                try{
	                    //String[] split = line.split("\t");
	                    String[] split = line.split("\\s+");
	                    String typeCapteur="";
	                    @SuppressWarnings("unused")
	                    String nomCapteur="";
						String time="";
	                    String mesureCapteur="";
	                    String room="" ;
	                    String valeurCapteur="";

	                    switch (split[2].substring(0,1)) {
	                        case "D":
	                            typeCapteur = "Porte";
	                            time =split[1];
	                            switch (split[2].substring(0,4)) {
                                case "D001":
                                	room ="Living";
                                	nomCapteur="D001";
                                	break;
                                case "D002":
                                	room ="Kitchen";
                                	nomCapteur="D002";
                                	break;
                                case "D003":
                                    room= "Bathroom_big";
                                	nomCapteur="D003";
                                    break;
                                case "D004":
                                    room= "Office";
                                	nomCapteur="D004";
                                    break;

	                            }

	                            break;
	                        case "T":
	                            typeCapteur = "Temperature";
	                            time =split[1];
	                            switch (split[2].substring(0,4)) {
	                                case "T001":
	                                	room ="Bedroom";
	                                	nomCapteur="T001";
	                                	break;
	                                case "T002":
	                                	room ="Living";
	                                	nomCapteur="T002";
	                                    break;
	                                case "T003":
	                                	room ="Kitchen";
	                                	nomCapteur="T003";
	                                	break;
	                                case "T004":
	                                	room ="Bathroom_big";
	                                	nomCapteur="T004";
	                                    break;
	                                case "T005":
	                                	room ="Office";
	                                	nomCapteur="T005";
	                                	break;
	                              
	                            }
	                          	    	                 
	    	                    

	                            break;
	                        case "M":
	                        	typeCapteur = "Mouvement";
	                            time =split[1];
	                            switch (split[2].substring(0,4)) {
                                case "M001":
                                	room ="Bedromm";
                                	nomCapteur="M001";
                                	break;
                                case "M002":
                                	nomCapteur="M002";
                                	room ="Bedroom";
                                	break;
                                case "M003":
                                    room= "Bedroom";
                                	nomCapteur="M003";
                                    break;
                                case "M004":
                                	room ="Bedroom";
                                	nomCapteur="M004";
                                	break;
                                case "M005":
                                	nomCapteur="M005";
                                	room ="Bedroom";
                                	break;
                                case "M006":
                                    room= "Bedroom";
                                	nomCapteur="M006";
                                    break;
                                case "M007":
                                	room ="Bedroom";
                                	nomCapteur="M007";
                                	break;
                                case "M008":
                                	nomCapteur="M008";
                                	room ="Living";
                                	break;
                                case "M009":
                                    room= "Living";
                                	nomCapteur="M009";
                                    break;
                                case "M010":
                                	room ="Living";
                                	nomCapteur="M010";
                                	break;
                                case "M011":
                                	nomCapteur="M011";
                                	room ="Living";
                                	break;
                                case "M012":
                                    room= "Living";
                                	nomCapteur="M012";
                                    break;
                                case "M013":
                                	room ="Bedromm";
                                	nomCapteur="M013";
                                	break;
                                case "M014":
                                	nomCapteur="M014";
                                	room ="Dining";
                                	break;
                                case "M015":
                                    room= "Kitchen";
                                	nomCapteur="M015";
                                    break;
                                case "M016":
                                	room ="Kitchen";
                                	nomCapteur="M016";
                                	break;
                                case "M017":
                                	nomCapteur="M017";
                                	room ="Kitchen";
                                	break;
                                case "M018":
                                    room= "Kitchen";
                                	nomCapteur="M018";
                                    break;
                                case "M019":
                                	room ="Kitchen";
                                	nomCapteur="M019";
                                	break;
                                case "M020":
                                	nomCapteur="M020";
                                	room ="Living";
                                	break;
                                case "M021":
                                    room= "Dining";
                                	nomCapteur="M021";
                                    break;
                                case "M022":
                                	room ="Bedroom";
                                	nomCapteur="M022";
                                	break;
                                case "M023":
                                	nomCapteur="M023";
                                	room ="Bedroom";
                                	break;
                                case "M024":
                                    room= "Bedroom";
                                	nomCapteur="M024";
                                    break;
                                case "M025":
                                	room ="Office";
                                	nomCapteur="M025";
                                	break;
                                case "M026":
                                	nomCapteur="M026";
                                	room ="Office";
                                	break;
                                case "M027":
                                    room= "Office";
                                	nomCapteur="M027";
                                    break;
                                case "M028":
                                    room= "Office";
                                	nomCapteur="M028";
                                    break;
                                case "M029":
                                	room ="Bathroom_big";
                                	nomCapteur="M029";
                                	break;
                                case "M030":
                                	nomCapteur="M030";
                                	room ="Bathroom_big";
                                	break;
                                case "M031":
                                    room= "Bathroom_big";
                                	nomCapteur="M031";
                                    break;
	                            }

	                            break;
	                            
	                    }
	                    TimeUnit.SECONDS.sleep(0);

	                    valeurCapteur =split[3];
	                    if (model.contains(model.getResource(ns+nomCapteur),null, (RDFNode) null)) {
	                    	if (typeCapteur.equalsIgnoreCase("Mouvement") || typeCapteur.equalsIgnoreCase("Porte") ) {
	                    		System.out.println("Update............................>"+nomCapteur);
	    	                    JenaEngine.updateValueOfDataTypeProperty(model, ns,nomCapteur,"etat",valeurCapteur);
	    	                    JenaEngine.updateValueOfObjectProperty(model, ns,nomCapteur, "estDans",room);
	    	                    JenaEngine.updateValueOfDataTypeProperty(model,ns,nomCapteur,"date",time);
	    	             
	                    	}else {
	                    		System.out.println("Update............................>"+nomCapteur);
	                    		JenaEngine.updateValueOfDataTypeProperty(model, ns,nomCapteur,"degre",
	    	                    		Double.parseDouble(valeurCapteur));
	    	                    JenaEngine.updateValueOfObjectProperty(model, ns,nomCapteur, "estDans",room);
	    	                    JenaEngine.updateValueOfDataTypeProperty(model,ns,nomCapteur,"date",time);
	                    	}
	                    	
	                    }else {
	                    if (typeCapteur.equalsIgnoreCase("Mouvement") || typeCapteur.equalsIgnoreCase("Porte") ) {
                    		System.out.println("Create............................>"+nomCapteur);
	                    JenaEngine.createInstanceOfClass(model, ns,typeCapteur,nomCapteur);
	                    JenaEngine.addValueOfDataTypeProperty(model, ns,nomCapteur,"etat",valeurCapteur);
	                    JenaEngine.addValueOfObjectProperty(model, ns,nomCapteur, "estDans",room);
	                    JenaEngine.addValueOfDataTypeProperty(model,ns,nomCapteur,"date",time);
	                    }
	                    else { 
                    		System.out.println("Create............................>"+nomCapteur);
	                    	JenaEngine.createInstanceOfClass(model, ns,typeCapteur,nomCapteur);
	                    JenaEngine.addValueOfDataTypeProperty(model, ns,nomCapteur,"degre",
	                    		Double.parseDouble(valeurCapteur));
	                    JenaEngine.addValueOfObjectProperty(model, ns,nomCapteur, "estDans",room);
	                    JenaEngine.addValueOfDataTypeProperty(model,ns,nomCapteur,"date",time);
	                    	
	                    }
	                    }      
	                    TimeUnit.SECONDS.sleep(0);
	                    detectAction(model.listStatements(),model);
	                    
	                } catch(Exception e){
                    e.printStackTrace();
                }
	            });
                
	        } catch(Exception e){
	        		e.printStackTrace(); 
	        		
            }
	        
	  }
	  public static void detectAction(StmtIterator geriter, Model model) throws InterruptedException {
		  int bool=0;
		  while(geriter.hasNext()) {
			  Statement stmt = geriter.nextStatement();
			  Resource subject = stmt.getSubject();
			  Property predicate =stmt.getPredicate();
			  RDFNode object = stmt.getObject();
			  if(!object.toString().startsWith("http")) {
				  boolean one= false;
				  boolean two = false;
				  boolean three= false;
				  boolean four = false;
				  //Capteur porte Bathroom D003
				  if(subject.toString().equalsIgnoreCase("http://www.semanticweb.org/win10/ontologies/2021/0/untitled-ontology-15#D003")) {
						if((object.toString().split("http://www")[0]).equalsIgnoreCase("ON^^")) {
							one = true;
						}
				  }
				  //M31 capteur de mouvement dans BATHROOM
				  if(subject.toString().equalsIgnoreCase("http://www.semanticweb.org/win10/ontologies/2021/0/untitled-ontology-15#M031")) {
						if((object.toString().split("http://www")[0]).equalsIgnoreCase("ON^^")) {
		                   two=true;
						}
				  }
				  if(two) {
						TimeUnit.SECONDS.sleep(2);
						System.out.println("\n =====> Quelqu'un dans la douche");

				  }
				  //M0014 SALLE
				  if(subject.toString().equalsIgnoreCase("http://www.semanticweb.org/win10/ontologies/2021/0/untitled-ontology-15#M014")) {
						if((object.toString().split("http://www")[0]).equalsIgnoreCase("ON^^")) {
		                    TimeUnit.SECONDS.sleep(0);

							System.out.println("\n =====> Quelqu'un mange dans la salle");
						}
				  }
				  //M19 KITCHEN
				  if(subject.toString().equalsIgnoreCase("http://www.semanticweb.org/win10/ontologies/2021/0/untitled-ontology-15#M019")) {
					if((object.toString().split("http://www")[0]).equalsIgnoreCase("ON^^")) {
						three = true;
					}
				  }
				  //M0015 KITCHEN
				  if(subject.toString().equalsIgnoreCase("http://www.semanticweb.org/win10/ontologies/2021/0/untitled-ontology-15#M015")) {
						if((object.toString().split("http://www")[0]).equalsIgnoreCase("ON^^")) {
							four = true;
						}
				  }
				  if (three&&four) {
	                    TimeUnit.SECONDS.sleep(2);

					  System.out.println("\n ====> Quelqu'un fais à manger dans la cuisine");
				  }
			  
			  
		  }
	  }
}
}


	                    
	                    
	                    
	                    
	                    
	                    

	                    

	           
