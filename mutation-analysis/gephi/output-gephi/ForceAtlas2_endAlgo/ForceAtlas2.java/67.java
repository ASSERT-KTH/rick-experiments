/* LittleDarwin generated order-1 mutant
mutant type: RemoveMethod
----> before:     public void goAlgo() {
----> after:     public void goAlgo() {
----> line number in original file: 142
----> mutated node: 649

*/

/*
 Copyright 2008-2011 Gephi
 Authors : Mathieu Jacomy <mathieu.jacomy@gmail.com>
 Website : http://www.gephi.org

 This file is part of Gephi.

 DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

 Copyright 2011 Gephi Consortium. All rights reserved.

 The contents of this file are subject to the terms of either the GNU
 General Public License Version 3 only ("GPL") or the Common
 Development and Distribution License("CDDL") (collectively, the
 "License"). You may not use this file except in compliance with the
 License. You can obtain a copy of the License at
 http://gephi.org/about/legal/license-notice/
 or /cddl-1.0.txt and /gpl-3.0.txt. See the License for the
 specific language governing permissions and limitations under the
 License.  When distributing the software, include this License Header
 Notice in each file and include the License files at
 /cddl-1.0.txt and /gpl-3.0.txt. If applicable, add the following below the
 License Header, with the fields enclosed by brackets [] replaced by
 your own identifying information:
 "Portions Copyrighted [year] [name of copyright owner]"

 If you wish your version of this file to be governed by only the CDDL
 or only the GPL Version 3, indicate your decision by adding
 "[Contributor] elects to include this software in this distribution
 under the [CDDL or GPL Version 3] license." If you do not indicate a
 single choice of license, a recipient has the option to distribute
 your version of this file under either the CDDL, the GPL Version 3 or
 to extend the choice of license to its licensees as provided above.
 However, if you add GPL Version 3 code and therefore, elected the GPL
 Version 3 license, then the option applies only if the new code is
 made subject to such option by the copyright holder.

 Contributor(s):

 Portions Copyrighted 2011 Gephi Consortium.
 */

package org.gephi.layout.plugin.forceAtlas2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.gephi.graph.api.Edge;
import org.gephi.graph.api.Graph;
import org.gephi.graph.api.GraphModel;
import org.gephi.graph.api.Interval;
import org.gephi.graph.api.Node;
import org.gephi.layout.plugin.AbstractLayout;
import org.gephi.layout.plugin.forceAtlas2.ForceFactory.AttractionForce;
import org.gephi.layout.plugin.forceAtlas2.ForceFactory.RepulsionForce;
import org.gephi.layout.spi.Layout;
import org.gephi.layout.spi.LayoutBuilder;
import org.gephi.layout.spi.LayoutProperty;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 * ForceAtlas 2 Layout, manages each step of the computations.
 *
 * @author Mathieu Jacomy
 */
public class ForceAtlas2 implements Layout {

    private final ForceAtlas2Builder layoutBuilder;
    double outboundAttCompensation = 1;
    private GraphModel graphModel;
    private Graph graph;
    private double edgeWeightInfluence;
    private double jitterTolerance;
    private double scalingRatio;
    private double gravity;
    private double speed;
    private double speedEfficiency;
    private boolean outboundAttractionDistribution;
    private boolean adjustSizes;
    private boolean barnesHutOptimize;
    private double barnesHutTheta;
    private boolean linLogMode;
    private boolean normalizeEdgeWeights;
    private boolean strongGravityMode;
    private int threadCount;
    private int currentThreadCount;
    private Region rootRegion;
    private ExecutorService pool;

    public ForceAtlas2(ForceAtlas2Builder layoutBuilder) {
        this.layoutBuilder = layoutBuilder;
        this.threadCount = Math.min(4, Math.max(1, Runtime.getRuntime().availableProcessors() - 1));
    }

    @Override
    public void initAlgo() {
        AbstractLayout.ensureSafeLayoutNodePositions(graphModel);

        speed = 1.;
        speedEfficiency = 1.;

        graph = graphModel.getGraphVisible();

        graph.readLock();
        try {
            Node[] nodes = graph.getNodes().toArray();

            // Initialise layout data
            for (Node n : nodes) {
                if (n.getLayoutData() == null || !(n.getLayoutData() instanceof ForceAtlas2LayoutData)) {
                    ForceAtlas2LayoutData nLayout = new ForceAtlas2LayoutData();
                    n.setLayoutData(nLayout);
                }
                ForceAtlas2LayoutData nLayout = n.getLayoutData();
                nLayout.mass = 1 + graph.getDegree(n);
                nLayout.old_dx = 0;
                nLayout.old_dy = 0;
                nLayout.dx = 0;
                nLayout.dy = 0;
            }

            pool = Executors.newFixedThreadPool(threadCount);
            currentThreadCount = threadCount;
        } finally {
            graph.readUnlockAll();
        }
    }

    private double getEdgeWeight(Edge edge, boolean isDynamicWeight, Interval interval) {
        if (isDynamicWeight) {
            return edge.getWeight(interval);
        } else {
            return edge.getWeight();
        }
    }


    @Override
    public void goAlgo() {
// void -- no return //
}


    @Override
    public boolean canAlgo() {
        return graphModel != null;
    }

    @Override
    public void endAlgo() {
        graph.readLock();
        try {
            for (Node n : graph.getNodes()) {
                n.setLayoutData(null);
            }
            pool.shutdown();
        } finally {
            graph.readUnlockAll();
        }
    }

    @Override
    public LayoutProperty[] getProperties() {
        List<LayoutProperty> properties = new ArrayList<>();
        final String FORCEATLAS2_TUNING = NbBundle.getMessage(getClass(), "ForceAtlas2.tuning");
        final String FORCEATLAS2_BEHAVIOR = NbBundle.getMessage(getClass(), "ForceAtlas2.behavior");
        final String FORCEATLAS2_PERFORMANCE = NbBundle.getMessage(getClass(), "ForceAtlas2.performance");
        final String FORCEATLAS2_THREADS = NbBundle.getMessage(getClass(), "ForceAtlas2.threads");

        try {
            properties.add(LayoutProperty.createProperty(
                this, Double.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.scalingRatio.name"),
                FORCEATLAS2_TUNING,
                "ForceAtlas2.scalingRatio.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.scalingRatio.desc"),
                "getScalingRatio", "setScalingRatio"));

            properties.add(LayoutProperty.createProperty(
                this, Boolean.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.strongGravityMode.name"),
                FORCEATLAS2_TUNING,
                "ForceAtlas2.strongGravityMode.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.strongGravityMode.desc"),
                "isStrongGravityMode", "setStrongGravityMode"));

            properties.add(LayoutProperty.createProperty(
                this, Double.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.gravity.name"),
                FORCEATLAS2_TUNING,
                "ForceAtlas2.gravity.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.gravity.desc"),
                "getGravity", "setGravity"));

            properties.add(LayoutProperty.createProperty(
                this, Boolean.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.distributedAttraction.name"),
                FORCEATLAS2_BEHAVIOR,
                "ForceAtlas2.distributedAttraction.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.distributedAttraction.desc"),
                "isOutboundAttractionDistribution", "setOutboundAttractionDistribution"));

            properties.add(LayoutProperty.createProperty(
                this, Boolean.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.linLogMode.name"),
                FORCEATLAS2_BEHAVIOR,
                "ForceAtlas2.linLogMode.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.linLogMode.desc"),
                "isLinLogMode", "setLinLogMode"));

            properties.add(LayoutProperty.createProperty(
                this, Boolean.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.adjustSizes.name"),
                FORCEATLAS2_BEHAVIOR,
                "ForceAtlas2.adjustSizes.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.adjustSizes.desc"),
                "isAdjustSizes", "setAdjustSizes"));

            properties.add(LayoutProperty.createProperty(
                this, Double.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.edgeWeightInfluence.name"),
                FORCEATLAS2_BEHAVIOR,
                "ForceAtlas2.edgeWeightInfluence.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.edgeWeightInfluence.desc"),
                "getEdgeWeightInfluence", "setEdgeWeightInfluence"));

            properties.add(LayoutProperty.createProperty(
                this, Boolean.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.normalizeEdgeWeights.name"),
                FORCEATLAS2_BEHAVIOR,
                "ForceAtlas2.normalizeEdgeWeights.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.normalizeEdgeWeights.desc"),
                "isNormalizeEdgeWeights", "setNormalizeEdgeWeights"));

            properties.add(LayoutProperty.createProperty(
                this, Double.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.jitterTolerance.name"),
                FORCEATLAS2_PERFORMANCE,
                "ForceAtlas2.jitterTolerance.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.jitterTolerance.desc"),
                "getJitterTolerance", "setJitterTolerance"));

            properties.add(LayoutProperty.createProperty(
                this, Boolean.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.barnesHutOptimization.name"),
                FORCEATLAS2_PERFORMANCE,
                "ForceAtlas2.barnesHutOptimization.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.barnesHutOptimization.desc"),
                "isBarnesHutOptimize", "setBarnesHutOptimize"));

            properties.add(LayoutProperty.createProperty(
                this, Double.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.barnesHutTheta.name"),
                FORCEATLAS2_PERFORMANCE,
                "ForceAtlas2.barnesHutTheta.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.barnesHutTheta.desc"),
                "getBarnesHutTheta", "setBarnesHutTheta"));

            properties.add(LayoutProperty.createProperty(
                this, Integer.class,
                NbBundle.getMessage(getClass(), "ForceAtlas2.threads.name"),
                FORCEATLAS2_THREADS,
                "ForceAtlas2.threads.name",
                NbBundle.getMessage(getClass(), "ForceAtlas2.threads.desc"),
                "getThreadsCount", "setThreadsCount"));

        } catch (Exception e) {
            Exceptions.printStackTrace(e);
        }

        return properties.toArray(new LayoutProperty[0]);
    }

    @Override
    public void resetPropertiesValues() {
        int nodesCount = 0;

        if (graphModel != null) {
            nodesCount = graphModel.getGraphVisible().getNodeCount();
        }

        // Tuning
        if (nodesCount >= 100) {
            setScalingRatio(2.0);
        } else {
            setScalingRatio(10.0);
        }
        setStrongGravityMode(false);
        setGravity(1.);

        // Behavior
        setOutboundAttractionDistribution(false);
        setLinLogMode(false);
        setAdjustSizes(false);
        setEdgeWeightInfluence(1.);
        setNormalizeEdgeWeights(false);

        // Performance
        setJitterTolerance(1d);
        setBarnesHutOptimize(nodesCount >= 1000);
        setBarnesHutTheta(1.2);
        setThreadsCount(Math.max(1, Runtime.getRuntime().availableProcessors() - 1));
    }

    @Override
    public LayoutBuilder getBuilder() {
        return layoutBuilder;
    }

    @Override
    public void setGraphModel(GraphModel graphModel) {
        this.graphModel = graphModel;
        // Trick: reset here to take the profile of the graph in account for default values
        resetPropertiesValues();
    }

    public Double getBarnesHutTheta() {
        return barnesHutTheta;
    }

    public void setBarnesHutTheta(Double barnesHutTheta) {
        this.barnesHutTheta = barnesHutTheta;
    }

    public Double getEdgeWeightInfluence() {
        return edgeWeightInfluence;
    }

    public void setEdgeWeightInfluence(Double edgeWeightInfluence) {
        this.edgeWeightInfluence = edgeWeightInfluence;
    }

    public Double getJitterTolerance() {
        return jitterTolerance;
    }

    public void setJitterTolerance(Double jitterTolerance) {
        this.jitterTolerance = jitterTolerance;
    }

    public Boolean isLinLogMode() {
        return linLogMode;
    }

    public void setLinLogMode(Boolean linLogMode) {
        this.linLogMode = linLogMode;
    }

    public Boolean isNormalizeEdgeWeights() {
        return normalizeEdgeWeights;
    }

    public void setNormalizeEdgeWeights(Boolean normalizeEdgeWeights) {
        this.normalizeEdgeWeights = normalizeEdgeWeights;
    }

    public Double getScalingRatio() {
        return scalingRatio;
    }

    public void setScalingRatio(Double scalingRatio) {
        this.scalingRatio = scalingRatio;
    }

    public Boolean isStrongGravityMode() {
        return strongGravityMode;
    }

    public void setStrongGravityMode(Boolean strongGravityMode) {
        this.strongGravityMode = strongGravityMode;
    }

    public Double getGravity() {
        return gravity;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public Integer getThreadsCount() {
        return threadCount;
    }

    public void setThreadsCount(Integer threadCount) {
        this.threadCount = Math.max(1, threadCount);
    }

    public Boolean isOutboundAttractionDistribution() {
        return outboundAttractionDistribution;
    }

    public void setOutboundAttractionDistribution(Boolean outboundAttractionDistribution) {
        this.outboundAttractionDistribution = outboundAttractionDistribution;
    }

    public Boolean isAdjustSizes() {
        return adjustSizes;
    }

    public void setAdjustSizes(Boolean adjustSizes) {
        this.adjustSizes = adjustSizes;
    }

    public Boolean isBarnesHutOptimize() {
        return barnesHutOptimize;
    }

    public void setBarnesHutOptimize(Boolean barnesHutOptimize) {
        this.barnesHutOptimize = barnesHutOptimize;
    }
}
