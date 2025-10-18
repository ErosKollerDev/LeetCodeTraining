#!/usr/bin/env bash
# Delete all files in this project that end with *training.java
#
# Usage:
#   ./delete_training_java.sh            # preview deletions and prompt for confirmation
#   ./delete_training_java.sh -y         # delete without interactive prompt
#   ./delete_training_java.sh -n         # dry run (list only)
#   ./delete_training_java.sh -p PATH    # limit search to PATH (default: repo root)
#
# Notes:
# - Only files whose names end with "training.java" are targeted.
# - This script is safe by default: it previews and asks for confirmation unless -y is given.
# - It uses null-delimited paths to safely handle spaces and special characters.

set -euo pipefail

AUTO_YES=false
DRY_RUN=false
SEARCH_PATH=""

print_help() {
  grep '^#' "$0" | sed 's/^# \{0,1\}//'
}

while [[ $# -gt 0 ]]; do
  case "$1" in
    -y|--yes)
      AUTO_YES=true
      shift
      ;;
    -n|--dry-run)
      DRY_RUN=true
      shift
      ;;
    -p|--path)
      SEARCH_PATH=${2:-}
      if [[ -z "$SEARCH_PATH" ]]; then
        echo "Error: --path requires a value" >&2
        exit 2
      fi
      shift 2
      ;;
    -h|--help)
      print_help
      exit 0
      ;;
    *)
      echo "Unknown option: $1" >&2
      echo "Use -h for help." >&2
      exit 2
      ;;
  esac
done

# Determine project root (directory where this script resides)
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="${SEARCH_PATH:-$SCRIPT_DIR}"

# Find candidate files
mapfile -d '' FILES < <(find "$ROOT_DIR" -type f -name "*training.java" -print0)

if [[ ${#FILES[@]} -eq 0 ]]; then
  echo "No files ending with 'training.java' were found under: $ROOT_DIR"
  exit 0
fi

echo "The following files match '*training.java':"
printf '%s\n' "${FILES[@]}" | sed 's/^/  - /'

if [[ "$DRY_RUN" == true ]]; then
  echo "Dry run: no files were deleted."
  exit 0
fi

if [[ "$AUTO_YES" != true ]]; then
  read -r -p "Delete ${#FILES[@]} file(s)? This cannot be undone. [y/N]: " REPLY
  case "$REPLY" in
    [yY][eE][sS]|[yY])
      :
      ;;
    *)
      echo "Aborted. No files were deleted."
      exit 0
      ;;
  esac
fi

# Delete files safely
printf '%s\0' "${FILES[@]}" | xargs -0 rm -f --

echo "Deleted ${#FILES[@]} file(s)."