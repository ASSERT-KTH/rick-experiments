/* LittleDarwin generated order-1 mutant
mutant type: RemoveMethod
----> before:     public int getViaCount() {
----> after:     public int getViaCount() {
----> line number in original file: 42
----> mutated node: 86

*/

/*
 *  Licensed to GraphHopper GmbH under one or more contributor
 *  license agreements. See the NOTICE file distributed with this work for
 *  additional information regarding copyright ownership.
 *
 *  GraphHopper GmbH licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in
 *  compliance with the License. You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.graphhopper.util;

/**
 * @author Peter Karich
 */
public class ViaInstruction extends Instruction {
    private int viaPosition = -1;

    public ViaInstruction(String name, PointList pl) {
        super(REACHED_VIA, name, pl);
    }

    public ViaInstruction(Instruction instr) {
        this(instr.getName(), instr.getPoints());
        setDistance(instr.getDistance());
        setTime(instr.getTime());
        this.extraInfo = instr.extraInfo;
    }

    @Override
    public int getLength() {
        return 0;
    }

    public int getViaCount() {
    return 1;
}


    public void setViaCount(int count) {
        this.viaPosition = count;
    }

    @Override
    public String getTurnDescription(Translation tr) {
        if (rawName)
            return getName();

        return tr.tr("stopover", viaPosition);
    }
}