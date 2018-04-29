/**
 *
 * @author Nicolas 25.05.2016
 *
Greedy Pathfinding is a tool for visualizing the greedy algorithm.
Copyright (C) 2016  Nicolas Raube
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package views;

import java.awt.*;

public class Line {

    private int x1, x2, y1, y2;
    protected Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(color);
        graphics.drawLine(x1, y1, x2, y2);
    }

    public Point getCoords1() {
        return new Point(x1, y1);
    }

    public Point getCoords2() {
        return new Point(x2, y2);
    }

    public Color getColor() {
        return color;
    }

}
