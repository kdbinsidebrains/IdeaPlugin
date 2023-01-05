package org.kdb.inside.brains.view.chart;

import org.junit.jupiter.api.Test;
import org.kdb.inside.brains.KdbType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ChartConfigTest {
    @Test
    void applicable() {
        final ColumnConfig[] exist = new ColumnConfig[]{
                new ColumnConfig("col1", KdbType.FLOAT),
                new ColumnConfig("col2", KdbType.INT),
                new ColumnConfig("col3", KdbType.BOOLEAN),
                new ColumnConfig("col4", KdbType.SYMBOL)
        };
        final ChartDataProvider provider = mock(ChartDataProvider.class);
        when(provider.getColumns()).thenReturn(exist);

        final ChartConfig config = mock(ChartConfig.class);
        doCallRealMethod().when(config).isApplicable(provider);

        when(config.getColumns()).thenReturn(List.of(
                new ColumnConfig("col4", KdbType.SYMBOL),
                new ColumnConfig("col1", KdbType.FLOAT)
        ));
        assertTrue(config.isApplicable(provider));

        when(config.getColumns()).thenReturn(List.of(
                new ColumnConfig("col4", KdbType.BOOLEAN),
                new ColumnConfig("col1", KdbType.FLOAT)
        ));
        assertFalse(config.isApplicable(provider));

        when(config.getColumns()).thenReturn(List.of(
                new ColumnConfig("col4", KdbType.SYMBOL),
                new ColumnConfig("col12", KdbType.FLOAT)
        ));
        assertFalse(config.isApplicable(provider));
    }
}