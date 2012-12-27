/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.mime4j.field;

import org.apache.james.mime4j.dom.field.UnstructuredField;
import org.junit.Assert;
import org.junit.Test;

public class UnstructuredFieldTest {

    @Test
    public void testGetBody() throws Exception {
        UnstructuredField f = null;

        f = (UnstructuredField) DefaultFieldParser.parse("Subject: Yada\r\n yada yada\r\n");
        Assert.assertEquals("Testing folding value 1", "Yada yada yada", f.getValue());

        f = (UnstructuredField) DefaultFieldParser.parse("Subject:  \r\n\tyada");
        Assert.assertEquals("Testing folding value 2", " \tyada", f.getValue());

        f = (UnstructuredField) DefaultFieldParser.parse("Subject:yada");
        Assert.assertEquals("Testing value without a leading ' '", "yada", f.getValue());
    }

}
