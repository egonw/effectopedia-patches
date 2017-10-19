%%Rory Conolly
%February 20, 2017
%% 

%% Development notes
%January 31, 2017
%The fathead minnow (FHM) model of WanYun Cheng (Toxicol. Sci. 154,
%78 - 89, 2016 doi: 10.1093/toxsci/kfw142) was coded in Simbiology. 
%The current effort is to develop a plain MATLAB version for use in 
%Effectopedia - collaboration with WanYun and Hristo Aladjov
%% 

%% INITIAL
clc
disp('Running FHM_E2_VTG_run...')
%clear all 
format shorte
global param
tic ;%Starts the timer; toc at end gives elapsed time

FHM_initial; %initializes parameter values

%Simulation setup
%Use an initial run to allow the model to stabilize, a second run 
% where the fish are dosed with fadrozole, and finally a third run 
% for depuration
% (initialization)-(FAD exposure) - (depuration)
initialization_duration = 2000; %hr
exposure_start_time = 0; %keep at zero
exposure_duration = 192; %hours (8 days)
depuration_duration = 624; %hours (8 days)
 
run_start_time  = exposure_start_time - initialization_duration;
initialization_end_time = exposure_start_time - 1;
exposure_end_time = exposure_duration;
depuration_start_time = exposure_end_time + 1;
run_end_time = depuration_start_time + depuration_duration;

%ODES are solved from one event to the next
event_list = [run_start_time          %start initialization
              initialization_end_time
              exposure_start_time
              exposure_end_time
              depuration_start_time
              run_end_time];          %end of depuration

%Fadrozole was dosed as ug/L. Need to convert to umol/L for use here.
%Fadrozole MW = 223 (g/mol or ug/umol))
FAD_MW = 223; %(g/mol or ug/umol))
%Convert ug/L to umol/L by dividing by the MW
%For example, (30 ug/L)/(223 ug/umol) = 1.3453e-1 umol/L
%FAD_dose is how the exposure was described for the FHM experiments
%FAD_dose = 0;   %ug/L
%FAD_dose = 0.5; %ug/L
FAD_dose = 3;   %ug/L
FAD_dose = 30;  %ug/L
%param.FAD_conc is the exposure in ug/L converted to umol/L to  use in
%this model
param.FAD_conc = FAD_dose / FAD_MW; %umol/L (uM)

%End of INITIAL section
%%

%%
%DYNAMIC 

%Run the model, stepping through the event list
timex = [];%initialize -  holds simulated times
simdatax = [];%initialize - hold simulated data

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
    
    %Hold onto simulated data as we step through the event list
    timex = [timex; time]; %Save times from previous run
    simdatax = [simdatax; simdata]; %Save results from prevous run
end

%End of DYNAMIC
%%
%POSTPROCESSING
disp('Postprocessing...')

%Plotting...

%Load data for plasma E2 and plasma VTG
FAD_data;
if FAD_dose == 0
    E2_data = [FAD_data_control(:,1) FAD_data_control(:,2)];
    VTG_data = [FAD_data_control(:,1) FAD_data_control(:,4)]; 
elseif FAD_dose == 0.5
    E2_data = [FAD_data_0_5(:,1) FAD_data_0_5(:,2)];
    VTG_data = [FAD_data_0_5(:,1) FAD_data_0_5(:,4)];
elseif FAD_dose == 3
    E2_data = [FAD_data_3(:,1) FAD_data_3(:,2)];
    VTG_data = [FAD_data_3(:,1) FAD_data_3(:,4)];
elseif FAD_dose == 30
    E2_data = [FAD_data_30(:,1) FAD_data_30(:,2)];
    VTG_data = [FAD_data_30(:,1) FAD_data_30(:,4)];
end

%Plot plasma E2 simulation against data
%E2 in venous blood is state 11 in FHM_ide.m
xx = find(timex == -48); %48 hr or 2 days before start of dosing
%plot time in days rather than hours
subplot(1,2,1), plot((timex(xx):timex(end))/24,simdatax(xx:end,11))
hold on
subplot(1,2,1), plot(E2_data(:,1)/24, E2_data(:,2),'kx')
hold off
xlabel('Days')
ylabel('Venous E2 (uM)')
axis([-2, 35, 0, 0.1])
title(['Plasma E2, Fadrozole ' num2str(FAD_dose) ' ug/L'])
hold off

%Plot plasma VTG simulation against data
%VTG in venous blood is state 14
%plot time in days rather than hours
subplot(1,2,2), plot((timex(xx):timex(end))/24,simdatax(xx:end,14))
hold on
subplot(1,2,2), plot(VTG_data(:,1)/24, VTG_data(:,2),'ko')
hold off
xlabel('Days')
ylabel('Venous VTG (uM)')
axis([-2, 35, 0, 300])
title(['Plasma VTG, Fadrozole ' num2str(FAD_dose) ' ug/L'])

disp('    ')
disp('Finished')
disp(['Run lasted ' num2str(round(toc)/60) ' minutes'])

%End of Program
%%