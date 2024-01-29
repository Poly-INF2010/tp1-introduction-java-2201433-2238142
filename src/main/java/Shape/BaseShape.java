package Shape;

import Interface.Transform;
import Point.Point2d;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape extends Transform implements Cloneable {
    private final Collection<Point2d> coords;

//helper function to clone a list of points 
  public Collection<Point2d> cloneCoords(Collection<Point2d> coords) {
        return coords.stream().map(Point2d::clone).collect(Collectors.toList());
    }

    /** TODO
     * Create a BaseShape with empty coordinades
     */
    public BaseShape() {
        this.coords = new ArrayList<>();
    }

    /** TODO
     * Create a BaseShape from a collection of 2D points
     * @param coords The collection of 2D points
     */
    public BaseShape(Collection<Point2d> coords) {
        this.coords = cloneCoords(coords);
    }

    /** TODO
     * Add a deep copy of the 2D point to the Shape
     * @param coord 2D point to add
     * @return Updated BaseShape
     */
    public BaseShape add(Point2d coord) {
        coords.add(coord.clone());
        return this;
    }

    /** TODO
     * Add a deep copy of the 2D points of the shape to the current shape
     * @param shape Shape to add to the current shape
     * @return Updated BaseShape
     */
    public BaseShape add(BaseShape shape) {
        shape.coords.forEach(point -> add(point.clone()));
        return this;
    }

    /** TODO
     * Add a deep copy of the points in the collection to the shape
     * @param coords Collections of point to add
     * @return Updated BaseShape
     */
    public BaseShape addAll(Collection<Point2d> coords) {
        coords.forEach(point -> add(point.clone()));
        return this;
    }

    /** TODO
     * Remove the 2D point from the shape
     * @param coord Point to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(Point2d coord) {
        coords.removeIf(point -> point.equals(coord));
        return this;
    }

    /** TODO
     * Remove the 2D points in the shape from the current shape
     * @param shape Shape containing the points to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(BaseShape shape) {
        shape.coords.forEach(this::remove);
        return this;
    }

    /** TODO
     * Remove the 2D points in the collection from the current shape
     * @param coords Collection of 2D points to remove
     * @return Updated BaseShape
     */
    public BaseShape removeAll(Collection<Point2d> coords) {
        coords.forEach(this::remove);
        return this;
    }

    /** TODO
     *  Replace all the coords in a shape with new ones
     * @param newCoords new coords to replace the old one
     * @return Updated BaseShape
     * */
    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        coords.clear();
        coords.addAll(newCoords);
        return this;
    }

    /** TODO
     * Return a shallow copy of the coordinates of the shape
     * @return Shallow copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> getCoords() {
        return new ArrayList<>(coords);
    }

    /** TODO
     * Create and return a deep copy of the coordinates of the shape
     * @return Deep copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> cloneCoords() {
        return cloneCoords(coords);
    }

    /** TODO
     * @return Maximum X coordinate of the shape
     */
    public Double getMaxX() {
        Optional<Point2d> maxXPoint = coords.stream().max(Comparator.comparing(Point2d::X));
        return maxXPoint.isPresent() ? maxXPoint.get().X() : -Double.MAX_VALUE;
    }

    /** TODO
     * @return Maximum Y coordinate of the shape
     */
    public Double getMaxY() {
        Optional<Point2d> maxYPoint = coords.stream().max(Comparator.comparing(Point2d::Y));
        return maxYPoint.isPresent() ? maxYPoint.get().Y() : -Double.MAX_VALUE;
    }

    /** TODO
     * @return 2D Point containing the maximum X and Y coordinates of the shape
     */
    public Point2d getMaxCoord() {
        return new Point2d(getMaxX(), getMaxY());
    }

    /** TODO
     * @return Minimum X coordinate of the shape
     */
    public Double getMinX() {
        Optional<Point2d> minXPoint = coords.stream().min(Comparator.comparing(Point2d::X));
        return minXPoint.isPresent() ? minXPoint.get().X() : Double.MAX_VALUE;
    }

    /** TODO
     * @return Minimum Y coordinate of the shape
     */
    public Double getMinY() {
        Optional<Point2d> minYPoint = coords.stream().min(Comparator.comparing(Point2d::Y));
        return minYPoint.isPresent() ? minYPoint.get().Y() : Double.MAX_VALUE;
    }

    /** TODO
     * @return 2D point containing the minimum X and Y coordinate of the shape
     */
    public Point2d getMinCoord() {
        return new Point2d(getMinX(), getMinY());
    }

    /**
     * Rotate all points in the collection of current object
     * with the angle given
     * @param angle angle of rotation
     * @return rotated collection
     * */
    public Collection<Point2d> rotate(Double angle) {
        return super.rotate(cloneCoords(), angle);
    }

    /**
     * Translate all points in the collection of current object by the specified x and y offsets.
     * This method creates a new collection where each point is translated
     * with the angle given
     * @param x  The horizontal offset for the translation of each point.
     * @param y  The vertical offset for the translation of each point.
     * @return translated collection
     * */
    public Collection<Point2d> translate(Double x, Double y) {
        return super.translate(cloneCoords(), new Point2d(x, y));
    }

    /** TODO
     * @return Deep copy of the current shape
     */
    public BaseShape clone() {
        return new BaseShape(cloneCoords(coords));
    }
}
