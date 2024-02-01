package Letter;

import Shape.*;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;
    final static Double angle45Degree = Math.PI / 4;


    /** TODO
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        BaseShape shape = new BaseShape();
        Rectangle line = new Rectangle(halfStripeThickness, maxHeight);
        Rectangle middleLine = new Rectangle(halfMaxWidth, halfStripeThickness);
        BaseShape middleLineTranslate = new BaseShape();
        middleLineTranslate.addAll(middleLine.translate(0.0, halfMaxHeight / 4));
        BaseShape obliqueLineLeft = new BaseShape();
        BaseShape obliqueLineRight = new BaseShape();
        obliqueLineLeft.addAll(line.translate(-halfMaxWidth / 2, 0.0));
        obliqueLineRight.addAll(line.translate(halfMaxWidth / 2, 0.0));
        shape.addAll(obliqueLineLeft.rotate(angle45Degree / 4));
        shape.addAll(obliqueLineRight.rotate(-angle45Degree / 4));
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
        ellipse.removeAll(line.translate(halfMaxWidth - halfStripeThickness, 0.0));
        return ellipse;
    }

    /** TODO
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        BaseShape shape = new BaseShape();
        Rectangle rectangleToRemove = new Rectangle(maxWidth, halfMaxHeight - (halfStripeThickness + halfStripeThickness / 2));
        Rectangle rectangle = (Rectangle) new Rectangle(maxWidth, halfMaxHeight).removeAll(rectangleToRemove.translate(halfStripeThickness, 0.0));
        shape.addAll(rectangle.translate(0.0, -halfMaxHeight / 2));
        shape.addAll(rectangle.translate(0.0, halfMaxHeight / 2));
        shape.removeAll(new Rectangle(maxWidth, halfStripeThickness).translate(halfStripeThickness, halfStripeThickness));
        shape.removeAll(new Rectangle(maxWidth, halfStripeThickness).translate(halfStripeThickness, -halfStripeThickness));
        return shape;
    }

    /** TODO
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        Rectangle rectangle = new Rectangle(maxWidth, maxHeight);
        Rectangle rectangleToRemove = new Rectangle(maxWidth - stripeThickness, halfMaxHeight);
        rectangle.removeAll(rectangleToRemove.translate(0.0, (halfMaxHeight + halfStripeThickness) / 2));
        rectangle.removeAll(rectangleToRemove.translate(0.0, -(halfMaxHeight + halfStripeThickness) / 2));
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
        shape.addAll(line.rotate(-angle45Degree / 2));
        shape.addAll(line.translate(halfMaxWidth, 0.0));
        return shape;
    }

    /** TODO
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        return ellipse.remove(new Ellipse(maxWidth - stripeThickness, maxHeight - 2 * stripeThickness));
    }
}
