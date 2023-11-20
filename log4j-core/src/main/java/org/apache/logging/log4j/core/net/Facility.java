/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.logging.log4j.core.net;

import org.apache.logging.log4j.util.EnglishEnums;

/**
 *  The facility codes used by the Syslog system.
 *
 * <table>
 *     <caption>Facilities</caption>
 *     <tr>
 *         <th>Numerical Code</th>
 *         <th>Facility</th>
 *     </tr>
 *     <tr>
 *         <td>0</td>
 *         <td>kernel messages</td>
 *     </tr>
 *     <tr>
 *         <td>1</td>
 *         <td>user-level messages</td>
 *     </tr>
 *     <tr>
 *         <td>2</td>
 *         <td>mail system</td>
 *     </tr>
 *     <tr>
 *         <td>3</td>
 *         <td>system daemons</td>
 *     </tr>
 *     <tr>
 *         <td>4</td>
 *         <td>security/authorization messages</td>
 *     </tr>
 *     <tr>
 *         <td>5</td>
 *         <td>messages generated internally by syslogd</td>
 *     </tr>
 *     <tr>
 *         <td>6</td>
 *         <td>line printer subsystem</td>
 *     </tr>
 *     <tr>
 *         <td>7</td>
 *         <td>network news subsystem</td>
 *     </tr>
 *     <tr>
 *         <td>8</td>
 *         <td>UUCP subsystem</td>
 *     </tr>
 *     <tr>
 *         <td>9</td>
 *         <td>clock daemon</td>
 *     </tr>
 *     <tr>
 *         <td>10</td>
 *         <td>security/authorization messages</td>
 *     </tr>
 *     <tr>
 *         <td>11</td>
 *         <td>FTP daemon</td>
 *     </tr>
 *     <tr>
 *         <td>12</td>
 *         <td>NTP subsystem</td>
 *     </tr>
 *     <tr>
 *         <td>13</td>
 *         <td>log audit</td>
 *     </tr>
 *     <tr>
 *         <td>14</td>
 *         <td>log alert</td>
 *     </tr>
 *     <tr>
 *         <td>15</td>
 *         <td>clock daemon (note 2)</td>
 *     </tr>
 *     <tr>
 *         <td>16</td>
 *         <td>local use 0 (local0)</td>
 *     </tr>
 *     <tr>
 *         <td>17</td>
 *         <td>local use 1 (local1)</td>
 *     </tr>
 *     <tr>
 *         <td>18</td>
 *         <td>local use 2 (local2)</td>
 *     </tr>
 *     <tr>
 *         <td>19</td>
 *         <td>local use 3 (local3)</td>
 *     </tr>
 *     <tr>
 *         <td>20</td>
 *         <td>local use 4 (local4)</td>
 *     </tr>
 *     <tr>
 *         <td>21</td>
 *         <td>local use 5 (local5)</td>
 *     </tr>
 *     <tr>
 *         <td>22</td>
 *         <td>local use 6 (local6)</td>
 *     </tr>
 *     <tr>
 *         <td>23</td>
 *         <td>local use 7 (local7)</td>
 *     </tr>
 * </table>
 */
public enum Facility {

    /** Kernel messages. */
    KERN(0),

    /** User level messages. */
    USER(1),

    /** Mail system. */
    MAIL(2),

    /** System daemons. */
    DAEMON(3),

    /** Security/Authorization messages. */
    AUTH(4),

    /** Messages generated by syslogd. */
    SYSLOG(5),

    /** Line printer subsystem. */
    LPR(6),

    /** Network news subsystem. */
    NEWS(7),

    /** UUCP subsystem. */
    UUCP(8),

    /** Clock daemon. */
    CRON(9),

    /** Security/Authorization messages. */
    AUTHPRIV(10),

    /** FTP daemon. */
    FTP(11),

    /** NTP subsystem. */
    NTP(12),

    /** Log audit. */
    LOG_AUDIT(13),

    /** Log alert. */
    LOG_ALERT(14),

    /** Clock daemon. */
    CLOCK(15),

    /** Local use 0. */
    LOCAL0(16),

    /** Local use 1. */
    LOCAL1(17),

    /** Local use 2. */
    LOCAL2(18),

    /** Local use 3. */
    LOCAL3(19),

    /** Local use 4. */
    LOCAL4(20),

    /** Local use 5. */
    LOCAL5(21),

    /** Local use 6. */
    LOCAL6(22),

    /** Local use 7. */
    LOCAL7(23);

    private final int code;

    Facility(final int code) {
        this.code = code;
    }

    /**
     * Returns the Facility for the given string.
     *
     * @param name The Facility enum name, case-insensitive. If null, returns, null
     * @return a Facility enum value or null if name is null
     */
    public static Facility toFacility(final String name) {
        return toFacility(name, null);
    }

    /**
     * Returns the Facility for the given string.
     *
     * @param name The Facility enum name, case-insensitive. If null, returns, defaultFacility
     * @param defaultFacility the Facility to return if name is null
     * @return a Facility enum value or null if name is null
     */
    public static Facility toFacility(final String name, final Facility defaultFacility) {
        return EnglishEnums.valueOf(Facility.class, name, defaultFacility);
    }

    /**
     * Retrieve the value of the enumeration.
     * @return The value associated with the enumeration.
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Determine if this enumeration matches the specified name (ignoring case).
     * @param name The name to check.
     * @return true if the name matches this enumeration, ignoring case.
     */
    public boolean isEqual(final String name) {
        return this.name().equalsIgnoreCase(name);
    }
}
