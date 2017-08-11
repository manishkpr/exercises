package algo.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *                  1
 *                  |
 *            |-5 - 2 - 6
 *            |     |
 *            |     3
 *            |    / \
 *            |---4  7
 */
public class FindPath
{
    List<GNode> list = new LinkedList<>();

    @Test
    public void testFindPath()
    {
        Graph g = GraphBuilder.build();
        List<GNode> list = new LinkedList<>();
        findPath(g,g.nodes.get(1),g.nodes.get(6),list);

        System.out.println("Path");
        for(GNode n: list)
        {
            System.out.println(n.value);
        }
    }

    void findPath(Graph g, GNode head,GNode last, List<GNode> list) {
        // init all the nods to UNDISCOVERED
        for (GNode n : g.nodes) {
            n.status = GNode.Status.UNDISCOVERED;
        }

        // init queue
        Queue<GNode> queue = new LinkedList<>();
        // add root to the queue (at the end)
        queue.add(head);
        head.status = GNode.Status.DISCOVERED;

        // while the queue is not empty
        while (!queue.isEmpty()) {
            // extract first from the queue
            GNode actual = queue.remove();
            // process
            if (actual.status == GNode.Status.DISCOVERED) {
//                process(actual);
                actual.status = GNode.Status.PROCESSED;
            }
            // loop through all the other one
            for (GNode n : actual.adj) {
                if (n.status != GNode.Status.PROCESSED || g.isDirected) {
//                    processEdge(actual, n);
                }
                // add to the queue if not visited
                if (n.status == GNode.Status.UNDISCOVERED) {
                    queue.add(n);
                    n.parent = actual;
                    n.status = GNode.Status.DISCOVERED;
                    if(n==last)
                    {
                        break;
                    }
                }
            }
        }

        GNode toFind = last;
        while(toFind.parent!=null)
        {
            list.add(toFind);
            toFind = toFind.parent;
        }
        list.add(toFind);
    }

    private void findPath(GNode gNode1, GNode gNode2) {
        if(gNode1==gNode2)
        {
            System.out.print(gNode1+" <- ");
            list.add(gNode1);
        }
        else
        {
            findPath(gNode1,gNode2.parent);
            System.out.print(gNode2+" <- ");
            list.add(gNode2);
        }
    }
}
