/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2013 ForgeRock Inc.
 */
package org.forgerock.openam.entitlement.utils.indextree.treenodes;

/**
 * Wildcard tree node that will match any character except for '/' and '?' where this tree node is an end point.
 *  
 * @author apforrest
 */
public class SingleWildcardNode extends BasicTreeNode {

	public static final char WILDCARD = '^';

	@Override
	public char getNodeValue() {
		return WILDCARD;
	}

	@Override
	public boolean isWildcard() {
		return true;
	}

	@Override
	public boolean hasInterestIn(char value) {
		if (value == '/') {
			return false;
		}

		if (value == '?' && isEndPoint()) {
			return false;
		}

		return true;
	}

}