/*
 * Copyright 2012 Apigee Corporation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.usergrid;

import org.junit.ClassRule;
import org.junit.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.usergrid.utils.JsonUtils;

public abstract class AbstractCoreIT {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractCoreIT.class);
  @ClassRule
  public static CoreITSetup setup = new CoreITSetupImpl(CoreITSuite.cassandraResource);
  @Rule
  public CoreApplication app = new CoreApplication(setup);

  public void dump(Object obj) {
    dump("Object", obj);
  }

  public void dump(String name, Object obj) {
    if (obj != null && LOG.isInfoEnabled()) {
      LOG.info(name + ":\n" + JsonUtils.mapToFormattedJsonString(obj));
    }
  }
}
