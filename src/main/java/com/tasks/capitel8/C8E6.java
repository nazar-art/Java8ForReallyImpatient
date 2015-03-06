package com.tasks.capitel8;

import com.tasks.Exercise;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Using only methods of the Comparator class, define a comparator for Point2D
 * which is a total ordering (that is, the comparator only returns zero for equal
 * objects). Hint: First compare the x-coordinates, then the y-coordinates. Do
 * the same for Rectangle2D.
 */
public class C8E6 implements Exercise {

    @Test
    @Override
    public void perform() {
        Point2D pointA = new Point2D(2, 5);
        Point2D pointB = new Point2D(2, 5);
        Point2D pointC = new Point2D(2, 6);
        Comparator<Point2D> pointComparator = Comparator.comparingDouble(Point2D::getX).thenComparingDouble(Point2D::getY);
        assertTrue(pointComparator.compare(pointA, pointB) == 0);
        assertFalse(pointComparator.compare(pointA, pointC) == 0);
        Rectangle2D rectangleA = new Rectangle2D(2, 4, 5, 6);
        Rectangle2D rectangleB = new Rectangle2D(2, 4, 5, 6);
        Rectangle2D rectangleC = new Rectangle2D(2, 4, 6, 6);
        Comparator<Rectangle2D> rectangleComparator = Comparator.comparingDouble(Rectangle2D::getMinX)
                .thenComparingDouble(Rectangle2D::getMinY)
                .thenComparingDouble(Rectangle2D::getWidth)
                .thenComparingDouble(Rectangle2D::getHeight);
        assertTrue(rectangleComparator.compare(rectangleA, rectangleB) == 0);
        assertFalse(rectangleComparator.compare(rectangleA, rectangleC) == 0);
    }
}
