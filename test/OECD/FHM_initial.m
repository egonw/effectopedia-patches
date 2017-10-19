%FHM_initial
%Rory Conolly
%February 4, 2017

global MODPAR

%Brain
param.V_Brain =	1.20E-05;      %	
param.V_BrainBlood = 1.20E-07; %
param.E2 = 0;           %V_BrainBlood.E2
param.FAD = 0;           %V_BrainBlood.FAD
param.LHFSH = 0;%	     V_BrainBlood.LHFSH

%Gill
param.V_Gill = 1.58E-05; %V_BrainBlood.V_Gill
param.V_GillBlood = 1.58E-07 ;%

%Liver
param.V_Liver =	2.40E-05; %	
param.V_LiverBlood = 2.40E-07; %	
param.V_LiverTissue = 2.38E-05; %	

%Ovary
param.V_Ovary =	1.44E-04	;%	
param.V_OvaryBlood =	1.44E-06	;%	
param.V_OvaryTissue = 1.43E-04; %	

%ROB
param.V_ROB = 7.27E-04	;%Volume ROB tissue	
param.V_RobBlood =	7.26E-06; %	

%Venous blood
param.V_Venous =	2.45E-05; %Volume venous blood	

%Water in the fish tank
param.V_Water =	100.	;%Liters

%Model Scoped Parameters
% In SimBiology, parameters can be associated either with a model 
% (sometimes called "model-scoped parameters") or with a kinetic law of a 
% reaction ("reaction-scoped parameters"). A model-scoped parameter is 
% visible throughout the model and can be used in any reaction, event, or
% rule. A reaction-scoped parameter can only be used in the rate of the 
% reaction that it's associated with.
param.A_LHFSH_venous_free =	0	;%	
param.A_R_LHFSH_free =	2.88E-07	;%	
param.A_R_LHFSH_total =	2.88E-07	;%	
param.k_LHFSH =	0.0344	;%	
param.k_LHFSH_off =	0.0139	;%	
param.k_LHFSH_on =	7.86E-05	;%	
param.k_loss_CYP19A =	0.02056	;%	
param.k_loss_E2 =	3.73	;%	
param.k_loss_FAD =	46.98	; %First-order FAD clearance in liver	
param.k_loss_FAD_water =	1	;%First-order FAD clearance in water	
param.k_loss_LHFSH =	797	;%	
param.k_loss_LHFSH_brain =	48	;%	
param.k_loss_mRNA =	8.02	;%	
param.k_loss_T =	1.0897	;%	
param.k_storageVTGovary =	1	;%	
param.k_syn_LHFSH =	8	;%	
param.ka_syn_mRNA =	3.43E-10	;%	
param.KaVTGreceptor =	0.995335982	;%	
param.kcat_CYP19A	=	3.01E-04	;%	
param.kcatVTGtransport =	0.458818195	;%	
param.kdegVTGreceptor =	0.012917039	;%	
param.ki_E2 =	2.61E-05	;%	
param.Ki_fad =	MODPAR.ki_fad;%	
param.km_syn_CYP19A =	4428	;%	
param.Km_T =	3.37E-05	;%	
param.KmVTGtransport =	618.9233258	;%	
param.ksyn_mRNA_basel =	1.79E-10	;%	
param.ksyn_mRNA_max =	164	;%	
param.ksyn_T =	1.84E-06	;%	
param.ksyn_vtg =	874.6797064	;%	
param.ksynVTGreceptor =	0.001088994	;%	
param.kVTGtransfer =	0.065733656	;%	
param.LVTGtransfer =	6.50E-04	;%	
param.mass =	0	;%	
param.n1 =	3.855	;%	
param.OVTGtransfer_rate =	0	;%	

param.P_e2_brain_blood =	1	;%	
param.P_e2_liver_blood =	1	;%	
param.P_e2_ovary_blood =	1	;%	
param.P_e2_rob_blood = 1	;%	
param.P_fad_brain_blood =	1	;%	
param.P_fad_liver_blood =	1	;%	
param.P_fad_ovary_blood =	1	;%	
param.P_fad_rob_blood =	1	;%	
param.P_fad_water_blood =	1	;%	

param.Qbrain =	4.25E-04	;%	
param.Qcardiac =	0.0111	;%	
param.Qliver =	6.50E-04	;%	
param.Qovary =	0.006292	;%	
param.Qrob =	0.003738	;%	

param.QVTGcardiac =	0.0111	;%	
param.QVTGliver =	6.50E-04	;%	
param.QVTGovary =	0.006292	;%	

param.Qwater_gill =	0.05714	;%	

param.Vmax_CYP19A =	0	;%	
param.Vmax_syn_CYP19A =	0.00207	;%	
param.VmaxVTGtransport =	0	;%	

%State variable initial conditions
%y0 is the vector of state variable initial conditions
V_Ovary.FAD = 0.;
V_Ovary.E2 = 0.;
CYP19A = 0;%	V_Ovary.CYP19A
CYP19AmRNA = 1.00E-06; %	V_Ovary.CYP19AmRNA
T =	0	; %V_Ovary.T
V_Liver.FAD = 0.;
V_Liver.E2 = 0.;
V_ROB.FAD = 0.;
V_ROB.E2 = 0.;
V_Venous.FAD = 0;
E21 = 0; %V_Venous.E21
LHFSH_R_LHFSH =	0; %V_Venous.LHFSH_R_LHFSH
V_Venous.LHFSH = 0.;
VVTG = 0; %V_Venous.VVTG
V_Brain.FAD = 0; %V_Brain.FAD initial value
V_Brain.E2 = 0; %V_Brain.E2 initial value
V_Brain.LHFSH = 0; %V_Brain.LHFSH initial value
V_Water.FAD = 0.;
OBVTG =	0; %V_OvaryBlood.OBVTG
LBVTG =	0; %V_LiverBlood.LBVTG
BBVTG = 0; %BrainBlood.BBVTG initial value
RBVTG =	0; %V_RobBlood.RBVTG
GVTG = 0; %V_GillBlood.GVTG
VTGreceptor = 0; %V_OvaryTissue.VTGreceptor
OVTG =	0 ; %V_OvaryTissue.OVTG
LVTG = 0 ; %V_LiverTissue.LVTG

%Vector of initial conditions for passing to integration algorithm
y0 = [ V_Ovary.FAD;
    V_Ovary.E2;
    CYP19A %	V_Ovary.CYP19A
    CYP19AmRNA  %	V_Ovary.CYP19AmRNA
    T           %V_Ovary.T
    V_Liver.FAD
    V_Liver.E2
    V_ROB.FAD
    V_ROB.E2
    V_Venous.FAD
    E21
    LHFSH_R_LHFSH %V_Venous.LHFSH_R_LHFSH
    V_Venous.LHFSH
    VVTG
    V_Brain.FAD  %V_Brain.FAD initial value
    V_Brain.E2 %V_Brain.E2 initial value
    V_Brain.LHFSH %V_Brain.LHFSH initial value
    V_Water.FAD
    OBVTG %V_OvaryBlood.OBVTG
    LBVTG %V_LiverBlood.LBVTG
    BBVTG %BrainBlood.BBVTG initial value
    RBVTG %V_RobBlood.RBVTG
    GVTG %V_GillBlood.GVTG
    VTGreceptor %V_OvaryTissue.VTGreceptor
    OVTG %V_OvaryTissue.OVTG
    LVTG ]; %V_LiverTissue.LVTG

