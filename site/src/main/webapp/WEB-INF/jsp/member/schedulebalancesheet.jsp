<%@page import="com.mootly.wcm.beans.ValueListDocument"%>
<%@include file="../includes/tags.jspf"%>
<hst:link var="memberDriveComp" siteMapItemRefId="balancesheet"></hst:link>
<hippo-gogreen:title title="Schedule-BL" />
<w4india:itrmenu/>
<c:if test="${not empty formMap}">
	<c:forEach items="${formMap.message}" var="item">
		<div class="alert alert-error">
			<fmt:message key="${item.value}" />
		</div>
	</c:forEach>
</c:if>
<c:if test="${not empty screenConfigDocument}">
	<h4>
		<b><c:out value="${screenConfigDocument.screenHeading}" /></b>
	</h4>
	<c:if test="${not empty screenConfigDocument.screenSubHeading}">
		<div class="alert alert-info">
			<c:out value="${screenConfigDocument.screenSubHeading}" />
		</div>
	</c:if>
	<form name="${screenConfigDocument.screenHeading}" id="${screenConfigDocument.screenHeading}" action="<hst:actionURL/>" method="post">
		<c:if test="${not empty reFieldSetMap}">
			<c:forEach items="${reFieldSetMap}" var="fieldsetitem">
              <c:if test="${not empty fieldsetitem.value.fieldSetLegend}">
				<fieldset>
					<legend>
						<c:out value="${fieldsetitem.value.fieldSetLegend}"/>
					</legend>
                    </c:if>
					<c:forEach items="${totalScreenConfigMapforFS}" var="totalScreenConfigItem">
						<c:if test="${fieldsetitem.key == totalScreenConfigItem.key}">
							<c:forEach items="${totalScreenConfigItem.value}" var="totalScreenConfigValue">
								<c:forEach items="${totalScreenConfigValue.value}" var="screenFieldConfig" varStatus="st">
									<c:forEach items="${numValueListDocument.valueListDocumentDetailList}" var="numberValue">
										<c:if test="${numberValue.key == st.count}">
											<div class="span<c:out value="${screenFieldConfig.fieldSpan}"/>">
												<c:if test="${not empty screenFieldConfig.fieldLabel}">
													<div class="rowlabel">
														<label for="<c:out value="${screenFieldConfig.fieldId}"/>">
															<small><c:out value="${screenFieldConfig.fieldLabel}" /></small>
														</label>
													</div>
												</c:if>
												<div class="rowlabel">
													<c:if test="${screenFieldConfig.formFieldType == 'input'}">
														<input id="<c:out value="${screenFieldConfig.fieldId}"/>" 
															name="<c:out value="${screenFieldConfig.fieldName}"/>"
															type="<c:out value="${screenFieldConfig.inputFormFieldType}"/>"
															maxlength="<c:out value="${screenFieldConfig.fieldMaxLength}"/>"
															class="<c:out value="${screenFieldConfig.fieldClass}"/>"
															value=""
															<c:if test="${screenFieldConfig.readOnly}">readonly</c:if>/>
													</c:if>
													<c:if test="${screenFieldConfig.formFieldType == 'dropdown' }">
														<select name="<c:out value="${screenFieldConfig.fieldName}"/>"
															id="<c:out value="${screenFieldConfig.fieldId}"/>"
															class="<c:out value="${screenFieldConfig.fieldClass}"/>">
															<option value="">-Select-</option>
															<c:forEach items="${screenFieldConfigDropDownMap}" var="valueList">
																<c:if test="${screenFieldConfig.fieldId == valueList.key}">
																	<option value="${valueList.value.key}">${valueList.value.label}</option>
																</c:if>
															</c:forEach>
														</select>
													</c:if>
													<c:if test="${screenFieldConfig.formFieldType == 'anchor'}">
														<a href="<c:out value="${screenFieldConfig.href}"/>"
															id="<c:out value="${screenFieldConfig.fieldId}"/>"
															class="<c:out value="${screenFieldConfig.fieldClass}"/>">
															<c:out value="${screenFieldConfig.fieldName}" />
														</a>
													</c:if>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</c:forEach>
							</c:forEach>
						</c:if>
					</c:forEach>
              <c:if test="${not empty fieldsetitem.value.fieldSetLegend}">
				</fieldset>
              </c:if>
			</c:forEach>
		</c:if>
	</form>
	<res:client-validation screenConfigurationDocumentName="balancesheet" formId="${screenConfigDocument.screenHeading}"></res:client-validation>
</c:if>
<!-- Display all fields with out any presentation -->
<%-- <c:if
	test="${not empty screenConfigDocument.screenFieldSetDocumentList}">
	<c:forEach items="${screenConfigDocument.screenFieldConfigList}"
		var="screenFieldConfig">
		<fieldset>
			<legend> </legend>
			<div class="row-fluid show-grid">
				<div class="span<c:out value="${screenFieldConfig.fieldSpan}"/>">
					<div class="rowlabel">
						<label for="<c:out value="${screenFieldConfig.fieldId}"/>">
							<small><c:out value="${screenFieldConfig.fieldLabel}" /></small>
						</label>
					</div>
					<div class="rowlabel">
						<c:if test="${screenFieldConfig.formFieldType == 'input'}">
							<input id="<c:out value="${screenFieldConfig.fieldId}"/>"
								name="<c:out value="${screenFieldConfig.fieldName}"/>"
								type="<c:out value="${screenFieldConfig.inputFormFieldType}"/>"
								maxlength="<c:out value="${screenFieldConfig.fieldMaxLength}"/>"
								class="<c:out value="${screenFieldConfig.fieldClass}"/>"
								value=""
								<c:if test="${screenFieldConfig.readOnly}">readonly</c:if> />
						</c:if>
						<c:if test="${screenFieldConfig.formFieldType == 'dropdown' }">
							<select name="<c:out value="${screenFieldConfig.fieldName}"/>"
								id="<c:out value="${screenFieldConfig.fieldId}"/>"
								class="<c:out value="${screenFieldConfig.fieldClass}"/>">
								<option value="">-Select-</option>
								<c:forEach items="${screenFieldConfigDropDownMap}"
									var="valueList">
									<c:if test="${screenFieldConfig.fieldId == valueList.key}">
										<option value="${valueList.value.key}">${valueList.value.label}</option>
									</c:if>
								</c:forEach>
							</select>
						</c:if>
						<c:if test="${screenFieldConfig.formFieldType == 'anchor'}">
							<a href="<c:out value="${screenFieldConfig.href}"/>"
								id="<c:out value="${screenFieldConfig.fieldId}"/>"
								class="<c:out value="${screenFieldConfig.fieldClass}"/>"> <c:out
									value="${screenFieldConfig.fieldName}" />
							</a>
						</c:if>
					</div>
				</div>
			</div>
		</fieldset>
	</c:forEach>
</c:if>
--%>