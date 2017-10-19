%%Rory Conolly
%March 17, 2017
%% 

%% Development notes
%January 31, 2017
%The fathead minnow (FHM) model of WanYun Cheng (Toxicol. Sci. 154,
%78 - 89, 2016 doi: 10.1093/toxsci/kfw142) was coded in Simbiology. 
%The current effort is to develop a plain MATLAB version for use in 
%Effectopedia - collaboration with WanYun and Hristo Aladjov

%February 21, 2017
%Model now runs as MATLAB script for plasma E2 and plasma VTG simulations. 
%Now will modify this code to simulate fold change in ovarian CYP19A mRNA. 
%The fold change simualtion requires that the model be run twice, so that 
%mRNA levels for some nonzero exposure to fadrozole can be examined as a 
%ratio to the control levels (i.e., exposed/control).

%February 26, 2017
%Started work on modifying this code to run dose-response simulations.

%February 26, 2017
%Modified to predict effect of iprodione exposure on plasma VTG, using a
%TEF of 0.02 based on the ToxCast cell-based assay for inhibition or
%aromatase.
%% 

%% INITIAL
clc
disp('Running FHM_Dose_Response_run...')

format shorte
global param
global INPUT
global OUTPUT

tic ;%Starts the timer; toc at end gives elapsed time

FHM_Init_Parameters; %initializes parameter values

%Simulation setup
%Use an initial run to allow the model to stabilize, a second run 
% where the fish are dosed with fadrozole, and finally a third run 
% for depuration
% (initialization)-(FAD exposure) - (depuration)
initialization_duration = 2000; %hr
exposure_start_time = 0; %keep at zero
exposure_duration = 504; %hours Runor a long time to reach
                                %steady state 
depuration_duration = 0; %(hours) Don't want to depurate for a dose-
                         %response 
run_start_time  = exposure_start_time - initialization_duration;
initialization_end_time = exposure_start_time;
exposure_end_time = exposure_duration;

%ODES are solved from one event to the next
event_list = [run_start_time          %start initialization
              initialization_end_time
              exposure_start_time
              exposure_end_time];          %end of depuration

%Set up a vector of doses using Effectopedia input
doses = log10(INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration);
doses = [0, doses]; %include control
dose_response_data = -1 * ones(length(doses), length(y0));
activity = zeros(length(doses),1); %To hold CYP19A activities
          
%Fadrozole was dosed as ug/L. Need to convert to umol/L for use here.
%Fadrozole MW = 223 (g/mol or ug/umol))
FAD_MW = 223; %(g/mol or ug/umol))

%End of INITIAL section
%%

%%
%DYNAMIC 

for jjj = 1 : length(doses)
    
    disp(['Running dose ' num2str(doses(jjj)) ' ug/L'])
    timex = []; %initialize
    simdatax = []; %initialize
    
    %Convert ug/L to umol/L by dividing by the MW
    %For example, (30 ug/L)/(223 ug/umol) = 1.3453e-1 umol/L
    %FAD_dose is how the exposure was described for the FHM experiments
    %param.FAD_conc is the exposure in ug/L converted to umol/L to  use in
    %this model
    param.FAD_conc = doses(jjj) / FAD_MW; %umol/L (uM)

    %Run the model, stepping through the event list at each dose

    for i = 1:2:length(event_list)
    
        %Set the interval for simualtion
        tspan = event_list(i):event_list(i+1);
    
        %FAD dosing after initialization is complete
        if tspan(1) == exposure_start_time %start of exposure to FAD
            param.F_conc = param.FAD_conc;
        else
            param.F_conc = 0;
        end
            
        %Initial Conditions for solution of ODEs:
        if i ~= 1
            y0 = simdata(end,:); %Set initial conditions to values from 
                         %end of the previous run
        end
    
        %SOLVING THE ODEs
        % odeset sets parameters for the ODE solver
        options = odeset('RelTol', 1.e-12, 'AbsTol', 1.e-12, 'BDF', 'off' );

        %MATLAB integration algorithms
        % ode15s, ode23s, ode23t, ode23tb, ode45, ode23, ode113
        [time,simdata] = ode15s('FHM_ode',tspan,y0,options);
  
    end
    
    %Save dose-response data
    dose_response_data(jjj,:) = simdata(end,:); 
    
    %Ovarian CYP19A activity
    %Calculation for CYP19A activity (not a state variable)
    Vmax = param.kcat_CYP19A * simdata(end,3)* param.V_Ovary;
    activity(jjj) = Vmax*simdata(end,5) ...
                         /(param.Km_T*(1+(simdata(end,1)/param.Ki_fad)) ...
                         +simdata(end,5));
                   
end

%End of DYNAMIC
%%
%POSTPROCESSING
disp('Postprocessing...')

%State variables
%1 FAD in ovary
%2 E2 in ovary
%3 CYP19A in ovary
%4 CYP19A mRNA in ovary
%5 T (testosterone) in ovary
%6 FAD in liver
%7 E2 in liver
%8 FAD in rest of body
%9 E2 in rest of body
%10 FAD in venous blood
%11 E2 in venous blood
%12 Free form of LHFSH receptor 
%13 LHFSH in venous blood
%14 VTG in venous blood
%15 FAD in venous blood from brain
%16 E2 in venous blood from brain
%17 LHFSH in venous blood from brain
%18 FAD in water (This equation not used in MATLAB version of the model
%19 VTG in ovary blood
%20 VTG in liver blood
%21 VTG in brain blood
%22 VTG in rest of body blood
%23 VTG in gill blood
%24 VTG receptor in ovary
%25 VTG in ovary
%26 VTG in  liver

%Specify a TEF. Default is fadrozole TEF == 1
fadrozole = false; %Set to false if some other chemical
if fadrozole
    TEF = 1;
else
    TEF = 0.03; %iprodione
end

%Exporting to Effectopedia...
%Select the state to export
state = 11; % Plasma E2 uM

%Set Effectopedia output to % Plasma E2 dose response 
 OUTPUT.Tested_Subst_Log_Conc_Response_chemical_concentration = INPUT.Tested_Subst_Measured_Log_Conc_nom_chemical_concentration;
 OUTPUT.Tested_Subst_Log_Conc_Response = real(dose_response_data(:,state));
 OUTPUT.Tested_Subst_Log_Conc_Response(1) = []; %remomve control
 not_calculated = [];
 OUTPUT.Tested_Subst_Log_Conc_Response_time = not_calculated; % Time
 OUTPUT.Tested_Subst_Log_Conc_Response_stdiv_error = not_calculated; % Standard diviation error
 OUTPUT.Tested_Subst_Log_Conc_Response_sem_error = not_calculated; %% Standard error of mean
 OUTPUT.Tested_Subst_Log_Conc_Response_ci95_error = not_calculated; % 95% Confidence interval of mean
 OUTPUT.Tested_Subst_Log_Conc_Response_median = not_calculated; % Median value

disp('    ')
disp('Finished')
disp(['Run lasted ' num2str(round(toc)/60) ' minutes'])

%End of Program
%%