package nl.ecoquest.vk.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import nl.ecoquest.vk.model.SimulatorModel;

public class FieldView extends AbstractView {
	
	private int w = 500;
	private int h = 500;
	private static final long serialVersionUID = 1L;
	
	public Graphics g;
	public int xScale, yScale;
	
	private int gridWidth, gridHeight;
	private final int GRID_VIEW_SCALING_FACTOR = 5;
	
	private Dimension size;
	private Image fieldImage;
	
	
	/**
	 * Fieldview, shows the field
	 * @param model The simulator model
	 */
	public FieldView(SimulatorModel model) {
		super(model);
		setSize(w, h);

		size = new Dimension(0, 0);
		gridWidth = 120;
		gridHeight = 90;
	}
	
	/**
     * Tell the GUI manager how big we would like to be.
     */
    public Dimension getPreferredSize()
    {
        return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                             gridHeight * GRID_VIEW_SCALING_FACTOR);
    }

    /**
     * Prepare for a new round of painting. Since the component
     * may be resized, compute the scaling factor again.
     */
    public void preparePaint()
    {
        if(! size.equals(getSize())) {  // if the size has changed...
            size = getSize();
            fieldImage = this.createImage(size.width, size.height);
            g = fieldImage.getGraphics();

            xScale = size.width / gridWidth;
            if(xScale < 1) {
                xScale = GRID_VIEW_SCALING_FACTOR;
            }
            yScale = size.height / gridHeight;
            if(yScale < 1) {
                yScale = GRID_VIEW_SCALING_FACTOR;
            }
        }
    }

    /**
     * The field view component needs to be redisplayed. Copy the
     * internal image to screen.
     */
    public void paintComponent(Graphics g)
    {
        if(fieldImage != null) {
            Dimension currentSize = getSize();
            if(size.equals(currentSize)) {
                g.drawImage(fieldImage, 0, 0, null);
            }
            else {
                // Rescale the previous image.
                g.drawImage(fieldImage, 0, 0, currentSize.width, currentSize.height, null);
            }   
        }
    }
}
