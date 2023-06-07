/* LittleDarwin generated order-1 mutant
mutant type: ArithmeticOperatorReplacementBinary
----> before:                     (int) ((sourceColor.getGreen() + targetColor.getGreen()) / 2f),
----> after:                     (int) ((sourceColor.getGreen() + targetColor.getGreen()) * 2f),
----> line number in original file: 91
----> mutated node: 438

*/

/*
Copyright 2008-2011 Gephi
Authors : Mathieu Bastian
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

package org.gephi.preview.types;

import java.awt.Color;

/**
 * An edge color type. The color of an edge can be:
 * <ul>
 * <li>SOURCE: The source node's color</li>
 * <li>TARGET: The target node's color</li>
 * <li>MIXED: An average of source and target color</li>
 * <li>CUSTOM: A custom color</li>
 * <li>ORIGINAL: The original edge color, if exists</li></ul>
 *
 * @author Mathieu Bastian
 */
public class EdgeColor {

    private final Mode mode;
    private final Color customColor;

    public EdgeColor(Mode mode) {
        customColor = Color.BLACK;
        this.mode = mode;
    }

    public EdgeColor(Color customColor) {
        this.customColor = customColor;
        this.mode = Mode.CUSTOM;
    }

    public Mode getMode() {
        return mode;
    }

    public Color getCustomColor() {
        return customColor;
    }

    public Color getColor(Color edgeColor, Color sourceColor, Color targetColor) {
        switch (mode) {
            case ORIGINAL:
                return edgeColor != null ? edgeColor : Color.BLACK;
            case SOURCE:
                return sourceColor;
            case TARGET:
                return targetColor;
            case MIXED:
                return new Color((int) ((sourceColor.getRed() + targetColor.getRed()) / 2f),
                    (int) ((sourceColor.getGreen() + targetColor.getGreen()) * 2f),
                    (int) ((sourceColor.getBlue() + targetColor.getBlue()) / 2f),
                    (int) ((sourceColor.getAlpha() + targetColor.getAlpha()) / 2f));
            case CUSTOM:
                return customColor;
        }
        return null;
    }

    public enum Mode {

        SOURCE, TARGET, MIXED, CUSTOM, ORIGINAL
    }
}
