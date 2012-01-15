package creative.fire.jsfrf.jsf.event;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ComponentSystemEvent;

import org.apache.log4j.Logger;

/**
 * @author feuyeux@gmail.com
 * @version 1.0
 */
@ManagedBean
@RequestScoped
public class TestEvent {
	static Logger logger = Logger.getLogger(TestEvent.class);

	public void postAddToViewListener(ComponentSystemEvent event) {
		logger.info("1.PostAddToViewEvent :" + event.getClass().getName());
	}

	public void preRenderViewListener(ComponentSystemEvent event) {
		logger.info("2.PreRenderViewEvent :" + event.getClass().getName());
	}

	public void preRenderComponentListener(ComponentSystemEvent event) {
		logger.info("3.PreRenderComponentEvent :" + event.getClass().getName());
	}

	public void preValidateListener(ComponentSystemEvent event) {
		logger.info("->PreValidateEvent :" + event.getClass().getName());
	}

	public void postValidateListener(ComponentSystemEvent event) {
		logger.info("<-PostValidateEvent :" + event.getClass().getName());
	}

}