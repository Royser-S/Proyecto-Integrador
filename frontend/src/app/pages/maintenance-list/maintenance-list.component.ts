import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { LucideAngularModule } from 'lucide-angular';
import { MaintenanceService, Maintenance } from '../../services/maintenance.service';

@Component({
  selector: 'app-maintenance-list',
  standalone: true,
  imports: [CommonModule, RouterModule, LucideAngularModule],
  templateUrl: './maintenance-list.component.html',
  styleUrl: './maintenance-list.component.css'
})
export class MaintenanceListComponent implements OnInit {
  maintenances: Maintenance[] = [];
  loading = true;

  constructor(private maintenanceService: MaintenanceService) {}

  ngOnInit(): void {
    this.loadMaintenances();
  }

  loadMaintenances(): void {
    this.loading = true;
    this.maintenanceService.getAll().subscribe({
      next: (data) => {
        this.maintenances = data;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  deleteMaintenance(id: number): void {
    if (confirm('¿Está seguro de eliminar este registro de mantenimiento?')) {
      this.maintenanceService.delete(id).subscribe(() => {
        this.loadMaintenances();
      });
    }
  }
}
