% Fathead Minnow Hypothalamic-Pituitary-Gonadal Axis Model 
% Genereted using Efecttopedia ver.1.055 in-silico model settings interface
clear;

% Define data structures for exchange with Effectopedia.
global INPUT MODPAR OUTPUT

INPUT = struct (...   %Model input data structure
'Tested_Subst_Measured_Log_Conc', [-4.0, -3.0, -2.0, -1.0, 0.0],...   %logM Measured Concentration
'Tested_Subst_Measured_Log_Conc_time', [0.0, 0.0, 0.0, 0.0, 0.0],...   %s Time
'Tested_Subst_Measured_Log_Conc_nom_chemical_concentration', [-4.0, -3.0, -2.0, -1.0, -0.01],...   %logM Nominal chemical concentration
'Tested_Subst_Measured_Log_Conc_stdiv_error', [NaN, NaN, NaN, NaN, NaN],...   % Standard diviation error
'Tested_Subst_Measured_Log_Conc_sem_error', [0.1, 0.1, 0.1, 0.1, 0.1],...   %logM Standard error of mean
'Tested_Subst_Measured_Log_Conc_ci95_error', [NaN, NaN, NaN, NaN, NaN],...   % 95% Confidence interval of mean
'Tested_Subst_Measured_Log_Conc_median', [ NaN, NaN, NaN, NaN, NaN]...   % Median value
);

MODPAR = struct (...   %Model parameters
'ki_fad', [5.52E-05],...   % Inhibition constant for the chemical (Fadrozole) 
'ksyn_vtg', [874.6797064],...   % Synthesis rate of VTG influenced by E2
'k_storageVTGovary', [1],...   %% Storage rate of VTG to the ovary
'ksynVTGreceptor', [0.001088994]...   %% Synthesis rate of VTG receptor (transporter) to carry VTG into the ovary
);


OUTPUT = struct (...   %Model output data structure
'Tested_Subst_Log_Conc_Response', [],...   %% Measured response
'Tested_Subst_Log_Conc_Response_time', [],...   % Time
'Tested_Subst_Log_Conc_Response_chemical_concentration', [],...   %logM Measured chemical concentration
'Tested_Subst_Log_Conc_Response_stdiv_error', [],...   % Standard diviation error
'Tested_Subst_Log_Conc_Response_sem_error', [],...   %% Standard error of mean
'Tested_Subst_Log_Conc_Response_ci95_error', [],...   % 95% Confidence interval of mean
'Tested_Subst_Log_Conc_Response_median', []...   % Median value
);

% Execute the model using global parameters.

FHM_Dose_Percent_Inh_run