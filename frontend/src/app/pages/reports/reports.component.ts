import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LucideAngularModule } from 'lucide-angular';
import { FormsModule } from '@angular/forms';
import { ReportService, Report } from '../../services/report.service';
import { EquipmentService } from '../../services/equipment.service';
import { MaintenanceService } from '../../services/maintenance.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-reports',
  standalone: true,
  imports: [CommonModule, LucideAngularModule, FormsModule],
  templateUrl: './reports.component.html',
  styleUrl: './reports.component.css'
})
export class ReportsComponent implements OnInit {
  today = new Date();
  reports: Report[] = [];
  
  // Parametros del reporte a generar
  reportType = 'Equipos';
  reportFormat = 'PDF';
  
  stats = {
    totalReports: 0,
    downloads: 0,
    lastReportDate: 'Hoy'
  };

  constructor(
    private reportService: ReportService,
    private equipmentService: EquipmentService,
    private maintenanceService: MaintenanceService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.refreshReports();
    // Actualizar la hora cada minuto
    setInterval(() => { this.today = new Date(); }, 60000);
  }

  refreshReports(): void {
    this.reportService.getAll().subscribe(data => {
      this.reports = data;
      this.stats.totalReports = data.length;
    });
  }

  generateReport(): void {
    const userJson = localStorage.getItem('user');
    const user = userJson ? JSON.parse(userJson) : null;
    
    const newReport: Report = {
      idUsuario: user?.id,
      titulo: `Reporte de ${this.reportType} - ${new Date().toLocaleDateString()}`,
      tipo: this.reportType.toUpperCase(),
      fechaGeneracion: new Date().toISOString().split('T')[0],
      contenido: `Generado automáticamente en formato ${this.reportFormat}`
    };

    this.reportService.create(newReport).subscribe(() => {
      this.refreshReports();
      alert('Reporte generado exitosamente');
    });
  }

  deleteReport(id: number): void {
    if (confirm('¿Desea eliminar este reporte?')) {
      this.reportService.delete(id).subscribe(() => this.refreshReports());
    }
  }

  getIcon(type: string): string {
    return type === 'EQUIPOS' ? 'monitor' : 'wrench';
  }
}
