package io.mosip.pms.partner.manager.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author sanjeev.shrivastava
 *
 */
@Data
public class ActivateDeactivatePartnerRequest {
	
		@NotBlank(message="value is empty or null")
		public String status;
}
