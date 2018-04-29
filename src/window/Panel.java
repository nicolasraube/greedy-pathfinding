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

package window;

import algorithms.GreedyAlgorithm;
import views.Edge;
import views.Grid;
import views.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Panel extends JPanel {

    private Grid grid;
    private ArrayList<Node> nodes = new ArrayList<>();
    private ArrayList<Edge> edges = new ArrayList<>();

    private int addingNewEdgePoint = 0;
    private Point[] newEdgeCoords = new Point[2];
    private Node[] newEdgeConnectedNodes = new Node[2];

    public final Color COLOR_START_NODE = Color.green, COLOR_FINISH_NODE = Color.red, COLOR_NORMAL_NODE = Color.black;

    public Panel() {
        grid = new Grid();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);

                final Point coords = grid.getCoordsFor(new Rectangle(mouseEvent.getPoint(), new Dimension(1, 1)));

                switch (mouseEvent.getButton()) {

                    case MouseEvent.BUTTON1:

                        Node newNode = new Node(coords.x, coords.y, nodes.size(), COLOR_NORMAL_NODE);

                        if (!isNodeExisting(newNode)) {

                            if (nodes.size() == 0) {
                                newNode.setColor(COLOR_START_NODE);
                                nodes.add(newNode);
                            } else {
                                if (nodes.size() - 1 != 0)
                                    nodes.get(nodes.size() - 1).setColor(COLOR_NORMAL_NODE);

                                newNode.setColor(COLOR_FINISH_NODE);
                                nodes.add(newNode);
                            }

                            repaint();
                        }

                        break;

                    case MouseEvent.BUTTON3:

                        boolean isOnNode = false;
                        Node node = null;
                        for (Node n : nodes) {

                            if (n.getLocation().equals(coords)) {
                                isOnNode = true;
                                node = n;
                                break;
                            }

                        }

                        if (!isOnNode)
                            return;

                        newEdgeCoords[addingNewEdgePoint] = node.getCenter();
                        newEdgeConnectedNodes[addingNewEdgePoint] = node;

                        if (addingNewEdgePoint == 1) {

                            if (!newEdgeCoords[0].getLocation().equals(newEdgeCoords[1].getLocation()) && !isLineExisting(newEdgeCoords[0], newEdgeCoords[1])) {

                                Edge edge = new Edge(newEdgeCoords[0].x, newEdgeCoords[0].y, newEdgeCoords[1].x, newEdgeCoords[1].y, Color.blue);
                                edges.add(edge);
                                newEdgeConnectedNodes[0].getConnectedEdges().add(edge);
                                newEdgeConnectedNodes[1].getConnectedEdges().add(edge);

                                newEdgeConnectedNodes[0].getNextEdges().add(edge);

                                edge.getConnectedNodes().add(newEdgeConnectedNodes[0]);
                                edge.getConnectedNodes().add(newEdgeConnectedNodes[1]);

                                edge.setNextNode(newEdgeConnectedNodes[1]);

                                addingNewEdgePoint = 0;
                                repaint();

                            } else {

                                addingNewEdgePoint = 0;
                                newEdgeCoords[0] = null;
                                newEdgeCoords[1] = null;
                                newEdgeConnectedNodes[0] = null;
                                newEdgeConnectedNodes[1] = null;

                            }

                        } else {
                            addingNewEdgePoint++;
                        }

                        break;

                }

            }
        });

        initViews();
    }

    private void initViews() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JButton buttonStart = new JButton("Start");
        buttonStart.addActionListener(actionEvent -> {
            new GreedyAlgorithm(this);
        });
        add(buttonStart);

        JButton buttonReset = new JButton("Reset");
        buttonReset.addActionListener(actionEvent -> {
            nodes.clear();
            edges.clear();
            repaint();
        });
        add(buttonReset);

        JButton buttonExit = new JButton("Exit");
        buttonExit.addActionListener(actionEvent -> {
            System.exit(0);
        });
        add(buttonExit);

    }

    private boolean isLineExisting(Point coords1, Point coords2) {

        for (Edge edge : edges) {

            if (edge.getCoords1().equals(coords1) && edge.getCoords2().equals(coords2) || edge.getCoords1().equals(coords2) && edge.getCoords2().equals(coords1))
                return true;

        }

        return false;

    }

    private boolean isNodeExisting(Node n) {

        for (Node node : nodes) {
            if (node.getLocation().equals(n.getLocation())) {
                return true;
            }
        }

        return false;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        grid.paint(graphics);

        for (int i = 0; i < nodes.size(); i++)
            nodes.get(i).paint(graphics);

        for (int i = 0; i < edges.size(); i++)
            edges.get(i).paint(graphics);
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

}
