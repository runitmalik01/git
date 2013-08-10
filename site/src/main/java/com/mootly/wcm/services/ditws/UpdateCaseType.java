package com.mootly.wcm.services.ditws;

public enum UpdateCaseType {
	EmailResponse {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Response";
		};
	},
	Notes {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Notes";
		}
	},
	Attachment {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Attachment";
		}
	},
	AgentSearch {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "AgentSearch";
		}
	},
	Interview {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Interview";
		}
	},
	CloseCase {
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "CloseCase";
		}
	}	
}
