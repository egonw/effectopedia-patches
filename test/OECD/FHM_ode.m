%%ODE file for FHM model
%Rory Conolly
%February 20, 2017
%%

%%
function integrate = FHM_ode(~,statevalues)

global param; %everything that starts with param is global
integrate = zeros(length(statevalues),1) ;%initialize
%%

%%
%Get the results of the integration
V_Ovary.FAD = statevalues(1);      %
V_Ovary.E2 = statevalues(2);      %
CYP19A = statevalues(3);      %
CYP19AmRNA = statevalues(4);      %
T = statevalues(5);      %
V_Liver.FAD = statevalues(6);      %
V_Liver.E2 = statevalues(7);      %
V_ROB.FAD = statevalues(8);      %
V_ROB.E2 = statevalues(9);      %
V_Venous.FAD = statevalues(10);      %
E21 = statevalues(11);      %
LHFSH_R_LHFSH = statevalues(12);      %
V_Venous.LHFSH = statevalues(13);      %
VVTG = statevalues(14);      %
V_Brain.FAD = statevalues(15);      %
V_Brain.E2 = statevalues(16);      %
V_Brain.LHFSH = statevalues(17);      %
V_Water.FAD = statevalues(18);      %
OBVTG = statevalues(19);      %
LBVTG = statevalues(20);      %
BBVTG = statevalues(21);      %
RBVTG = statevalues(22);      %
GVTG = statevalues(23);      %
VTGreceptor = statevalues(24);      %
OVTG = statevalues(25);      %
LVTG = statevalues(26);      %
%%

%%
%Algebraic repeated Assignments

%Fadrozole in gill water (umol/L)
% (L/hr x umol/L + L/hr X umol/L) / (L/hr + L/hr) --> umol/L  
V_Gill.FAD = (param.Qwater_gill*param.F_conc + param.Qcardiac ...
    * V_Venous.FAD) / (param.Qcardiac+(param.Qwater_gill ...
    /param.P_fad_water_blood));

%LHFSH-receptor complex in venous blood (umol/L)
V_Venous.LHFSH_R_LHFSH = LHFSH_R_LHFSH;

%Free LHFSH receptor in venous blood (umol)
param.A_R_LHFSH_free = param.A_R_LHFSH_total ...
    -(V_Venous.LHFSH_R_LHFSH*param.V_Venous);

%Free (unbound) LHFSH in venous blood (umol)
A_LHFSH_venous_free = (V_Venous.LHFSH-V_Venous.LHFSH_R_LHFSH) ...
                      * param.V_Venous;

%CYP19A in ovary
param.Vmax_CYP19A  =  param.kcat_CYP19A*(CYP19A*param.V_Ovary);
                        %umol/hr

%E2 in venous blood
V_Venous.E21 = E21; %umol/L

%E2 in gill blood
V_Gill.E2  =  V_Venous.E21;  %umol/L

%LHFSH in gill blood
V_Gill.LHFSH  =  V_Venous.LHFSH;

%Vmax for VTG transport into the ovary
param.VmaxVTGtransport = VTGreceptor*param.kcatVTGtransport ...
                         * param.V_Ovary;   %umol/hr

%%

%%
%Fluxes	;
ReactionFlux1  =  param.Qbrain*V_Gill.E2; %E2 into brain 
ReactionFlux2  =  param.Qbrain*(V_Brain.E2/param.P_e2_brain_blood); %E2 out of brain
ReactionFlux3  =  param.Qbrain*V_Gill.FAD;
ReactionFlux4  =  param.Qbrain*(V_Brain.FAD/param.P_fad_brain_blood);
                    %L/hr X umol/L --> umol/hr
ReactionFlux5  =  param.k_syn_LHFSH	;
ReactionFlux6  =  param.k_loss_LHFSH_brain*V_Brain.LHFSH*param.V_Brain	;
ReactionFlux7  =  (param.k_LHFSH*V_Brain.LHFSH*param.V_Brain)/(1+(V_Brain.E2/param.ki_E2))	;
ReactionFlux8  =  param.Qovary*V_Gill.FAD	;
ReactionFlux9  =  param.Qovary*(V_Ovary.FAD/param.P_fad_ovary_blood)	;
ReactionFlux10  =  param.Qovary*V_Gill.E2	;
ReactionFlux11  =  param.Qovary*(V_Ovary.E2/param.P_e2_ovary_blood)	;
ReactionFlux12  =  param.Qrob*V_Gill.FAD	;
ReactionFlux13  =  param.Qrob*(V_ROB.FAD/param.P_fad_rob_blood)	;
ReactionFlux14  =  param.Qrob*V_Gill.E2	;
ReactionFlux15  =  param.Qrob*(V_ROB.E2/param.P_e2_rob_blood)	;
ReactionFlux16  =  param.Qliver*V_Gill.FAD	;
ReactionFlux17  =  param.Qliver*(V_Liver.FAD/param.P_fad_liver_blood)	;
ReactionFlux18  =  param.Qliver*V_Gill.E2	;
ReactionFlux19  =  param.Qliver*(V_Liver.E2/param.P_e2_liver_blood)	;
ReactionFlux20  =  param.Vmax_CYP19A*T/((param.Km_T*(1+(V_Ovary.FAD/param.Ki_fad)))+T)	;
ReactionFlux21  =  (param.Vmax_syn_CYP19A*CYP19AmRNA)/(param.km_syn_CYP19A+CYP19AmRNA)	;
ReactionFlux22  =  param.ksyn_mRNA_basel	;
ReactionFlux23  =  ((param.ksyn_mRNA_max-param.ksyn_mRNA_basel) ...
                   * LHFSH_R_LHFSH)/(param.ka_syn_mRNA+LHFSH_R_LHFSH);
ReactionFlux24  =  param.k_loss_LHFSH*A_LHFSH_venous_free	;
ReactionFlux25  =  param.k_LHFSH_on*A_LHFSH_venous_free*param.A_R_LHFSH_free	;
ReactionFlux26  =  param.k_LHFSH_off*(LHFSH_R_LHFSH*param.V_Venous)	;
ReactionFlux27  =  param.Qcardiac*E21	;
ReactionFlux28  =  param.Qcardiac*V_Venous.FAD	;
ReactionFlux29  =  param.k_loss_mRNA*CYP19AmRNA*param.V_Ovary	;
ReactionFlux30  =  param.k_loss_CYP19A*CYP19A*param.V_Ovary	;
ReactionFlux31  =  param.k_loss_FAD*V_Liver.FAD*param.V_Liver	;
ReactionFlux32  =  param.k_loss_E2*V_Liver.E2*param.V_Liver	;
ReactionFlux33  =  param.Qcardiac*A_LHFSH_venous_free/param.V_Venous	;
ReactionFlux34  =  param.k_loss_FAD_water*V_Water.FAD*param.V_Water; %FAD loss in water
ReactionFlux35  =  param.ksyn_T-param.k_loss_T*T*param.V_Ovary	;
ReactionFlux36  =  param.QVTGcardiac*VVTG	;
ReactionFlux37  =  (param.k_storageVTGovary*OVTG)*param.V_OvaryTissue	;
ReactionFlux38  =  param.QVTGliver*LBVTG	;
ReactionFlux39  =  param.ksyn_vtg*V_Liver.E2*param.V_Liver	;
ReactionFlux40  =  param.Qrob*RBVTG	;
ReactionFlux41  =  param.Qbrain*BBVTG	;
ReactionFlux42  =  param.Qovary*OBVTG	;
ReactionFlux43  =  param.Qovary*GVTG	;
ReactionFlux44  =  param.Qbrain*GVTG	;
ReactionFlux45  =  param.Qrob*GVTG	;
ReactionFlux46  =  param.Qliver*GVTG	;
ReactionFlux47  =  LVTG*param.QVTGliver	;
ReactionFlux48  =  param.ksynVTGreceptor*param.KaVTGreceptor^param.n1/(param.KaVTGreceptor^param.n1+OVTG^param.n1)	;
ReactionFlux49  =  (param.kdegVTGreceptor*VTGreceptor)*param.V_OvaryTissue	;
ReactionFlux50  =  param.VmaxVTGtransport*OBVTG/(param.KmVTGtransport+OBVTG)	;
%%

%%
%Differential equations
%1 FAD in ovary
dV_Ovary.FADdt =  1/param.V_Ovary*(ReactionFlux8 - ReactionFlux9);
integrate(1) = dV_Ovary.FADdt; 

%2 E2 in ovary
dV_Ovary.E2dt =  1/param.V_Ovary*(ReactionFlux10 - ReactionFlux11 + ReactionFlux20)	;
integrate(2) = dV_Ovary.E2dt; 

%3 CYP19A in ovary
dCYP19Adt =  1/param.V_Ovary*(ReactionFlux21 - ReactionFlux30)	;
integrate(3) = dCYP19Adt; 

%4 CYP19A mRNA in ovary
dCYP19AmRNAdt =  1/param.V_Ovary*(ReactionFlux22 + ReactionFlux23 - ReactionFlux29)	;
integrate(4) = dCYP19AmRNAdt; 

%5 testosterone in ovary
dTdt =  1/param.V_Ovary*(-ReactionFlux20 + ReactionFlux35)	;
integrate(5) = dTdt; 

%6 FAD in liver
dV_Liver.FADdt =  1/param.V_Liver*(ReactionFlux16 - ReactionFlux17 - ReactionFlux31)	;
integrate(6) = dV_Liver.FADdt; 

%7 E2 in liver
dV_Liver.E2dt =  1/param.V_Liver*(ReactionFlux18 - ReactionFlux19 - ReactionFlux32)	;
integrate(7) = dV_Liver.E2dt; 

%8 FAD in rest of body
dV_ROB.FADdt =  1/param.V_ROB*(ReactionFlux12 - ReactionFlux13)	;
integrate(8) = dV_ROB.FADdt; 

%9 E2 in rest of body
dV_ROB.E2dt =  1/param.V_ROB*(ReactionFlux14 - ReactionFlux15)	;
integrate(9) = dV_ROB.E2dt; 

%10 FAD in venous blood
% 1/L X umol
dV_Venous.FADdt = 1/param.V_Venous*(ReactionFlux4 + ReactionFlux9 + ReactionFlux13 + ReactionFlux17 - ReactionFlux28)	;
integrate(10) = dV_Venous.FADdt;

%11 E2 in venous blood
dE21dt = 1/param.V_Venous*(ReactionFlux2 + ReactionFlux11 + ReactionFlux15 + ReactionFlux19 - ReactionFlux27)	;
integrate(11) = dE21dt; 

%12 Free form of LHFSH receptor 
dLHFSH_R_LHFSHdt =  1/param.V_Venous*(ReactionFlux25 - ReactionFlux26)	;
integrate(12) = dLHFSH_R_LHFSHdt;

%13 LHFSH in venous blood
dV_Venous.LHFSHdt =  1/param.V_Venous*(ReactionFlux7 - ReactionFlux24 - ReactionFlux33)	;
integrate(13) = dV_Venous.LHFSHdt;

%14 VTG in venous blood
dVVTGdt =  1/param.V_Venous*(-ReactionFlux36 + ReactionFlux38 + ReactionFlux40 + ReactionFlux41 + ReactionFlux42)	;
integrate(14) = dVVTGdt; 

%15 FAD in venous blood from brain
dV_Brain.FADdt =  1/param.V_Brain*(ReactionFlux3 - ReactionFlux4)	;
integrate(15) = dV_Brain.FADdt; 

%16 E2 in venous blood from brain
dV_Brain.E2dt =  1/param.V_Brain*(ReactionFlux1 - ReactionFlux2)	;
integrate(16) = dV_Brain.E2dt; 

%17 LHFSH in venous blood from brain
dV_Brain.LHFSHdt =  1/param.V_Brain*(ReactionFlux5 - ReactionFlux6 - ReactionFlux7)	;
integrate(17) = dV_Brain.LHFSHdt;

%18 FAD in water (This equation not used in MATLAB version of the model
%dV_Water.FADdt =  1/param.V_Water*(-ReactionFlux34);
dV_Water.FADdt =  0;
integrate(18) = dV_Water.FADdt; 

%19 VTG in ovary blood
dOBVTGdt =  1/param.V_OvaryBlood*(-ReactionFlux42 + ReactionFlux43 - ReactionFlux50)	;
integrate(19) = dOBVTGdt; 

%20 VTG in liver blood
dLBVTGdt =  1/param.V_LiverBlood*(-ReactionFlux38 + ReactionFlux46 + ReactionFlux47)	;
integrate(20) = dLBVTGdt; 

%21 VTG in brain blood
dBBVTGdt =  1/param.V_BrainBlood*(-ReactionFlux41 + ReactionFlux44)	;
integrate(21) = dBBVTGdt; 

%22 VTG in rest of body blood
dRBVTGdt =  1/param.V_RobBlood*(-ReactionFlux40 + ReactionFlux45)	;
integrate(22) = dRBVTGdt; 

%23 VTG in gill blood
dGVTGdt =  1/param.V_GillBlood*(ReactionFlux36 - ReactionFlux43 - ReactionFlux44 - ReactionFlux45 - ReactionFlux46)	;
integrate(23) = dGVTGdt;

%24 VTG receptor in ovary
dVTGreceptordt =  1/param.V_OvaryTissue*(ReactionFlux48 - ReactionFlux49)	;
integrate(24) = dVTGreceptordt;

%25 VTG in ovary
dOVTGdt =  1/param.V_OvaryTissue*(-ReactionFlux37 + ReactionFlux50);
integrate(25) = dOVTGdt;

%26 VTG in  liver
dLVTGdt = 1/param.V_LiverTissue*(ReactionFlux39 - ReactionFlux47);
integrate(26) = dLVTGdt;
%%
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
