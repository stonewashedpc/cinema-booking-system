package baseTypes;

public class Texts {
	public static final String notDone = "Modification was not carried out!";
	public static final String consViol = "Constraint Violated: ";
	public static final String injectivityConstraintViolated = ": Injectivity " + consViol + notDone;
	public static final String surjectivityConstraintViolated = ": Surjectivity " + consViol + notDone;
	public static final String containmentConstraintViolated = "Containment " + consViol+ notDone;
	public static final String partialMapConstraintViolated = ": Partial Map " + consViol + notDone;
	public static final String totalMapConstraintViolated = ": Total Map " + consViol  + notDone;
}
