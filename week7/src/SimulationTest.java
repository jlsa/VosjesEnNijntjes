import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Joel Hoekstra
 *
 */
public class SimulationTest {

	@Test
	public void test() {
		Simulator sim = new Simulator();
		sim.simulateOneStep();
		sim.simulate(10);
		sim.runLongSimulation();
	}

}
