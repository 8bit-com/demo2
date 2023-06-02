{{/*
Create chart name and version as used by the chart label.
*/}}
{{- define "helper-values.chart" -}}
{{- printf "%s-%s" .Chart.Name .Chart.Version | replace "+" "_" | trunc 63 | trimSuffix "-" }}
{{- end }}

{{- define "helper-values.fullname" -}}
{{- printf "%s" .Chart.Name | trunc 63 | trimSuffix "-" -}}
{{- end -}}

{{/*
Common labels
*/}}
{{- define "helper-values.labels" -}}
helm.sh/chart: {{ include "helper-values.chart" . }}
{{ include "helper-values.selectorLabels" . }}
{{- if .Chart.AppVersion }}
app.kubernetes.io/version: {{ .Chart.AppVersion | quote }}
{{- end }}
app.kubernetes.io/managed-by: {{ .Release.Service }}
{{- if .Values.monitoring.enable }}
prometheus.io/jmx_scrape: "true"
{{- end }}
{{- end }}

{{/*
Selector labels
*/}}
{{- define "helper-values.selectorLabels" -}}
app.kubernetes.io/name: {{ .Chart.Name }}
app.kubernetes.io/instance: {{ .Release.Name }}
{{- end }}
