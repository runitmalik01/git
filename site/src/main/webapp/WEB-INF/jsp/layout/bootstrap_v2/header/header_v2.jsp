<%--

    Copyright (C) 2010 Hippo B.V.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

--%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.onehippo.org/jsp/google-analytics" prefix="ga" %>
<%@include file="../../../includes/tags.jspf" %>

  <div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <hst:include ref="logo"/>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#pricing">Pricing</a></li>
            <li class="dropdown">
				<a href="#taxes" class="dropdown-toggle" data-toggle="dropdown">Tax Filing <b class="caret"></b></a>
				<ul class="dropdown-menu">
	                <li class="dropdown-header">Calculators</li>
	                <li><a href="#">Tax Calculator</a></li>
	                <li><a href="#">NPV Calculator</a></li>
					<li><a href="#">EMI Calculator</a></li>
					<li><a href="#">HRA Calculator</a></li>
					<li class="divider"></li>
	                <li><a href="#">Income Tax Return</a></li>
	                <li><a href="#">Knowledge Portal</a></li>
              	</ul>
			</li>
            <li class="dropdown">
              <a href="#about" class="dropdown-toggle" data-toggle="dropdown">About Us <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">About</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">News</a></li>
              </ul>
            </li>
          </ul>
          <form class="navbar-form navbar-right">
            <button type="submit" class="btn btn-info">Login</button>
						<button type="submit" class="btn btn-warning">Sign Up</button>
          </form>
        </div><!--/.navbar-collapse -->
      </div>
    </div>

	<%-- 
	<hst:include ref="menu-top"/>
	<hst:include ref="logo"/>
	<hst:include ref="top-widget"/>
	
	<hst:include ref="menu-main"/>
	--%>
    



