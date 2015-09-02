package pluradj.titan.tinkerpop3.example;

import static org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.__.*;

import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;

import java.util.ArrayList;

import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaExample {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(JavaExample.class);

    public static void main(String[] args) {
        String dataDir = "./data";
        TitanGraph graph = TitanFactory.open("berkeleyje:" + dataDir);

        // see org.apache.tinkerpop.gremlin.tinkergraph.structure.TinkerFactory.generateClassic()
        final Vertex marko = graph.addVertex("name", "marko", "age", 29);
        final Vertex vadas = graph.addVertex("name", "vadas", "age", 27);
        final Vertex lop = graph.addVertex("name", "lop", "lang", "java");
        final Vertex josh = graph.addVertex("name", "josh", "age", 32);
        final Vertex ripple = graph.addVertex("name", "ripple", "lang", "java");
        final Vertex peter = graph.addVertex("name", "peter", "age", 35);
        marko.addEdge("knows", vadas, "weight", 0.5f);
        marko.addEdge("knows", josh, "weight", 1.0f);
        marko.addEdge("created", lop, "weight", 0.4f);
        josh.addEdge("created", ripple, "weight", 1.0f);
        josh.addEdge("created", lop, "weight", 0.4f);
        peter.addEdge("created", lop, "weight", 0.2f);

        GraphTraversalSource g = graph.traversal();
        Vertex fromNode = g.V().has("name", "marko").next();
        Vertex toNode = g.V().has("name", "peter").next();
        ArrayList list = new ArrayList();
        g.V(fromNode).repeat(both().simplePath()).until(is(toNode)).limit(1).path().fill(list);
        LOGGER.info(list.toString());
        System.exit(0);
    }
}
