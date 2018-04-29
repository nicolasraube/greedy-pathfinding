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

import views.Grid;

import javax.swing.*;

public class Window extends JFrame {

    private final int WIDTH;
    private final int HEIGHT;

    public Window() {

        WIDTH = Grid.LINE_GAP + Grid.LINE_GAP * Grid.LINE_COUNT;
        HEIGHT = Grid.LINE_GAP + Grid.LINE_GAP * Grid.LINE_COUNT;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);

        setContentPane(new Panel());

    }

}
