import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { EquipmentListComponent } from './pages/equipment-list/equipment-list.component';
import { EquipmentFormComponent } from './pages/equipment-form/equipment-form.component';
import { MaintenanceListComponent } from './pages/maintenance-list/maintenance-list.component';
import { MaintenanceFormComponent } from './pages/maintenance-form/maintenance-form.component';
import { ReportsComponent } from './pages/reports/reports.component';
import { MainLayoutComponent } from './components/layout/main-layout/main-layout.component';
import { authGuard } from './services/auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'login', component: LoginComponent, title: 'Login - Gestión de Activos' },
  { 
    path: '',
    component: MainLayoutComponent,
    canActivate: [authGuard],
    children: [
      { path: 'dashboard', component: DashboardComponent, title: 'Dashboard - Gestión de Activos' },
      { 
        path: 'equipos', 
        children: [
          { path: '', component: EquipmentListComponent, title: 'Equipos - Gestión de Activos' },
          { path: 'nuevo', component: EquipmentFormComponent, title: 'Nuevo Equipo - Gestión de Activos' },
          { path: 'editar/:id', component: EquipmentFormComponent, title: 'Editar Equipo - Gestión de Activos' }
        ]
      },
      {
        path: 'mantenimientos',
        children: [
          { path: '', component: MaintenanceListComponent, title: 'Mantenimientos - Gestión de Activos' },
          { path: 'nuevo', component: MaintenanceFormComponent, title: 'Nuevo Mantenimiento - Gestión de Activos' },
          { path: 'editar/:id', component: MaintenanceFormComponent, title: 'Editar Mantenimiento - Gestión de Activos' }
        ]
      },
      {
        path: 'reportes',
        children: [
          { path: '', component: ReportsComponent, title: 'Reportes - Gestión de Activos' }
        ]
      }
    ]
  },
  { path: '**', redirectTo: 'dashboard' }
];
