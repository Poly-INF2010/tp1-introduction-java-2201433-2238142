package Letter;

import Shape.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        BaseShape shape = new BaseShape();
        Rectangle line = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle middleLine = new Rectangle(halfMaxWidth, halfStripeThickness);
        BaseShape middleLineTranslate = new BaseShape();
        middleLineTranslate.addAll(middleLine.translate(0.0, halfMaxHeight / 2));
        BaseShape obliqueLine1 = new BaseShape();
        BaseShape obliqueLine2 = new BaseShape();
        obliqueLine1.addAll(line.translate(-halfMaxWidth / 2, 0.0));
        obliqueLine2.addAll(line.translate(halfMaxWidth / 2, 0.0));
        shape.addAll(obliqueLine1.rotate(Math.PI / 16));
        shape.addAll(obliqueLine2.rotate(-Math.PI / 16));
        shape.add(middleLineTranslate);
        return shape;
    }

    /** TODO
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        BaseShape shape = new BaseShape();
        Circle circle = (Circle) new Circle(halfMaxHeight).remove(new Circle(halfMaxHeight - stripeThickness));
        shape.addAll(circle.translate(0.0, -halfMaxHeight / 2));
        shape.addAll(circle.translate(0.0, halfMaxHeight / 2));
        Rectangle line = new Rectangle(stripeThickness, maxHeight);
        return shape.addAll(line.translate(-(stripeThickness + halfStripeThickness), 0.0));
    }

    /** TODO
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        ellipse.remove(new Ellipse(maxWidth - stripeThickness, maxHeight - stripeThickness));
        Rectangle line = new Rectangle(2 * stripeThickness, halfMaxHeight);
        ellipse.removeAll(line.translate(halfMaxWidth - stripeThickness, 0.0));
        return ellipse;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        BaseShape shape = new BaseShape();
        Square square = (Square) new Square(halfMaxHeight).remove(new Rectangle(halfMaxHeight - stripeThickness, halfMaxHeight - stripeThickness));
        shape.addAll(square.translate(0.0, -halfMaxHeight / 2));
        shape.addAll(square.translate(0.0, halfMaxHeight / 2));
        Rectangle line = new Rectangle(2 * stripeThickness, 2 * maxHeight);
        shape.removeAll(line.translate(halfMaxHeight / 2 - halfStripeThickness, 0.0));
        return shape;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle rectangle = new Rectangle(maxWidth, maxHeight);
        Rectangle rectangleToRemove = new Rectangle(maxWidth - stripeThickness, halfMaxHeight);
        rectangle.removeAll(rectangleToRemove.translate(0.0, (halfMaxHeight / 2) + halfStripeThickness));
        rectangle.removeAll(rectangleToRemove.translate(0.0, -((halfMaxHeight / 2) + halfStripeThickness)));
        return rectangle;
    }

    /** TODO
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        BaseShape shape = new BaseShape();
        Rectangle line = new Rectangle(halfStripeThickness, maxHeight);
        shape.addAll(line.translate(-halfMaxWidth, 0.0));
        shape.addAll(line.rotate(-Math.PI / 8));
        shape.addAll(line.translate(halfMaxWidth, 0.0));
        return shape;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        return ellipse.remove(new Ellipse(maxWidth - stripeThickness, maxHeight - stripeThickness));
    }
}
