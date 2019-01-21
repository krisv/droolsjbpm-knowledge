/*
 * Copyright 2018 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.internal.task.api.prediction;

import java.util.Map;

public class PredictionOutcome {

    private boolean present;

    private double confidenceLevel;
    
    private double confidenceThreshold;

    private int datasetSize;

    private int dataSizeThreshold;

    private Map<String, Object> data;
    
    public PredictionOutcome() {
        this.present = false;
    }

    public PredictionOutcome(double confidenceLevel, double confidenceThreshold, int datasetSize, int dataSizeThreshold, Map<String, Object> data) {
        this.present = data != null;        
        this.confidenceLevel = confidenceLevel;
        this.confidenceThreshold = confidenceThreshold;
        this.datasetSize = datasetSize;
        this.dataSizeThreshold = dataSizeThreshold;
        this.data = data;
    }

    public boolean isPresent() {
        return this.present;
    }
    
    public boolean isCertain() {
        return this.present && confidenceLevel > confidenceThreshold && this.datasetSize > this.dataSizeThreshold;
    }


    public double getConfidenceLevel() {
        return confidenceLevel;
    }

    public Map<String, Object> getData() {
        return data;
    }
}
