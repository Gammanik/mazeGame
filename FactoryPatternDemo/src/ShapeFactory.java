
public class ShapeFactory {
	public Shape createShape(String shapeType) 
	{
		if(shapeType.equalsIgnoreCase("Circle"))
		{
			return new Circle();
		}
		else if(shapeType.equalsIgnoreCase("Square"))
		{
			return new Square();
		}
		else if(shapeType.equalsIgnoreCase("Triangle"))
		{
			return new Triangle();
		}
		return null;
	}
}
