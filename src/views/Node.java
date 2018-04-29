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
import java.util.ArrayList;

public class Node extends Rectangle {

    private ArrayList<Edge> connectedEdges = new ArrayList<>();
    private ArrayList<Edge> nextEdges = new ArrayList<>();
    private final int SIZE;
    private Color color;
    private final int index;

    public Node(int x, int y, int index, Color color) {
        SIZE = Grid.LINE_GAP / 2;
        this.x = x;
        this.y = y;
        this.index = index;
        this.color = color;
    }

    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setStroke(new BasicStroke(4));

        g2d.setColor(color);
        g2d.drawRect(x, y, SIZE, SIZE);
    }

    public int getIndex() {
        return index;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getCenter() {
        return new Point((int) getX() + SIZE / 2, (int) getY() + SIZE / 2);
    }

    public ArrayList<Edge> getConnectedEdges() {
        return connectedEdges;
    }

    public ArrayList<Edge> getNextEdges() {
        return nextEdges;
    }

}
