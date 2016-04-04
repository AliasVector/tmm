package com.mar.tmm.desktop.ui.view.impl;

import com.mar.tmm.desktop.ui.view.KinematicPairPainter;
import com.mar.tmm.desktop.ui.view.UnitPainter;
import com.mar.tmm.desktop.ui.view.nodes.AbstractNode;
import com.mar.tmm.desktop.ui.view.nodes.RotationPairNode;
import com.mar.tmm.desktop.ui.view.nodes.TranslationPairNode;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.impl.Disposition;
import com.mar.tmm.model.impl.kinematicpair.RotationalPair;
import com.mar.tmm.model.impl.kinematicpair.TranslationalPair;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default implementation of {@link UnitPainter} interface.
 */
public class DefaultKinematicPairPainter implements KinematicPairPainter {

    public static final Logger LOGGER = LoggerFactory.getLogger(DefaultKinematicPairPainter.class);

    private static final Map<Class<? extends KinematicPair>, ConcreatePairPainter<? extends KinematicPair>> PAINTERS;

    static {
        PAINTERS = new HashMap<>();
        PAINTERS.put(TranslationalPair.class,
                (ConcreatePairPainter<TranslationalPair>) (final TranslationalPair pair, final double angle) -> {
                    if (pair == null) {
                        LOGGER.debug("Cannot paint translation rair which is null");
                        return null;
                    }

                    final Disposition disposition = pair.getDisposition();
                    final double x = disposition.getOffsetX();
                    final double y = disposition.getOffsetY();

                    final TranslationPairNode result = new TranslationPairNode(x, y, pair.getName());
                    result.rotateAroundCenter(angle);
                    LOGGER.debug("Finished painting translation pair node");
                    return result;
                });
        PAINTERS.put(RotationalPair.class,
                (ConcreatePairPainter<RotationalPair>) (final RotationalPair pair, final double angle) -> {
                    if (pair == null) {
                        LOGGER.debug("Cannot paint rotation rair which is null");
                        return null;
                    }

                    final Disposition disposition = pair.getDisposition();
                    final double x = disposition.getOffsetX();
                    final double y = disposition.getOffsetY();

                    final RotationPairNode result = new RotationPairNode(x, y, pair.getName());
                    LOGGER.debug("Finished painting rotation pair node");
                    return result;
                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T extends KinematicPair> AbstractNode paint(final T pair, final double angle) {
        if (pair == null) {
            LOGGER.warn("Cannot paint kinematic pair which is null");
            return null;
        }

        @SuppressWarnings("uncheked")
        final ConcreatePairPainter<T> painter = (ConcreatePairPainter<T>) PAINTERS.get(pair.getClass());
        return painter.paint(pair, angle);
    }

    interface ConcreatePairPainter<T extends KinematicPair> {
        AbstractNode paint(T pair, double angle);
    }

}
