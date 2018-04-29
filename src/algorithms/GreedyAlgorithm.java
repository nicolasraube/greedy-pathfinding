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

package algorithms;

import views.Edge;
import views.Node;
import window.Panel;

import java.awt.*;
import java.util.ArrayList;

public class GreedyAlgorithm {

    private final Color COLOR_SHORTEST_EDGE = Color.yellow;

    private Panel panel;
    private ArrayList<Node> nodes;

    public GreedyAlgorithm(Panel panel) {
        this.panel = panel;
        this.nodes = panel.getNodes();

        findPath(nodes.get(0));
    }

    private void findPath(Node node) {

        Edge smallestEdge = getSmallestEdge(node.getNextEdges());
        smallestEdge.setColor(COLOR_SHORTEST_EDGE);

        if (smallestEdge.getNextNode().getIndex() != nodes.size() - 1) {
            findPath(smallestEdge.getNextNode());
        } else {
            panel.repaint();
        }

    }

    private Edge getSmallestEdge(ArrayList<Edge> edges) {
        Edge smallestEdge = edges.get(0);

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);

            if (edge.getWeight() < smallestEdge.getWeight())
                smallestEdge = edge;

        }

        return smallestEdge;
    }

}
