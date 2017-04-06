
public class Main {

	public static void main(String[] args) 
	{
	ShapeFactory shapeFactory = new ShapeFactory();
	shapeFactory.createShape("Circle").draw();
	shapeFactory.createShape("Square").draw();
	shapeFactory.createShape("Triangle").draw();

	}

}
