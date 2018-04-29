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

public class Edge extends Line {

    private ArrayList<Node> connectedNodes = new ArrayList<>();
    private Node nextNode;
    private double weight = -1;

    public Edge(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D graphics = (Graphics2D) g;
        graphics.setStroke(new BasicStroke(3));

        graphics.setColor(getColor());
        graphics.drawLine(getCoords1().x, getCoords1().y, getCoords2().x, getCoords2().y);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWeight() {

        if(weight == -1) {
            double x = getCoords2().x - getCoords1().x;
            double y = getCoords1().y - getCoords2().y;

            weight = Math.sqrt((x * x) + (y * y));
        }

        return weight;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public ArrayList<Node> getConnectedNodes() {
        return connectedNodes;
    }

}
