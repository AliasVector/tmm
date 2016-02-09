package com.mar.tmm.model.impl.group;

import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mar.tmm.model.Group;
import com.mar.tmm.model.KinematicPair;
import com.mar.tmm.model.Unit;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Abstract group functionality.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractGroup implements Group {
    private static final int UNITS_RATE = 3;
    private static final int P5_RATE = 2;

    private String name;
    private List<KinematicPair> kinematicPairs = Lists.newArrayList();

    @Override
    public String getName() {
        return null;
    }

    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KinematicPair> getExternalKinematicPairs() {
        return kinematicPairs;
    }

    public void setExternalKinematicPairs(final List<KinematicPair> kinematicPairs) {
        this.kinematicPairs = kinematicPairs;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
            .append("name", name)
            .append("kinematicPairs", kinematicPairs)
            .toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateFreedomDegrees() {
        final Set<Unit> groupUnits = Sets.newHashSet();
        final Set<KinematicPair> p4Pairs = Sets.newHashSet();
        final Set<KinematicPair> p5Pairs = Sets.newHashSet();

        for (final KinematicPair externalPair : getExternalKinematicPairs()) {
            collectItemsForKinematicPair(groupUnits, p4Pairs, p5Pairs, externalPair);
        }

        return UNITS_RATE * groupUnits.size() - P5_RATE * p5Pairs.size() - p4Pairs.size();
    }

    private void collectItemsForKinematicPair(final Set<Unit> units, final Set<KinematicPair> p4Pairs,
        final Set<KinematicPair> p5Pairs, final KinematicPair pair) {

        if (pair != null && !p4Pairs.contains(pair) && !p5Pairs.contains(pair)) {
            if (KinematicPair.KinematicClass.P4 == pair.getKinematicClass()) {
                p4Pairs.add(pair);
            } else if (KinematicPair.KinematicClass.P5 == pair.getKinematicClass()) {
                p5Pairs.add(pair);
            }

            if (pair.getElement1() != null) {
                units.add(pair.getElement1().getUnit());
            }
            if (pair.getElement2() != null) {
                units.add(pair.getElement2().getUnit());
            }

            for (final KinematicPair sibling : getSiblingsKinematicPairs(pair)) {
                collectItemsForKinematicPair(units, p4Pairs, p5Pairs, sibling);
            }
        }
    }

    private Set<KinematicPair> getSiblingsKinematicPairs(final KinematicPair kinematicPair) {
        final Set<KinematicPair> result = Sets.newHashSet();
        if (kinematicPair.getElement1() != null) {
            for (final Unit.Element element : kinematicPair.getElement1().getUnit().getElements()) {
                result.add(element.getKinematicPair());
            }
        }

        // Remove kinematic pair itself
        result.remove(kinematicPair);
        return result;
    }
}
